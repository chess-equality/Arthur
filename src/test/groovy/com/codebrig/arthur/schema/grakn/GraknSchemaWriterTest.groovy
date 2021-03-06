package com.codebrig.arthur.schema.grakn

import com.codebrig.arthur.ArthurTest
import com.codebrig.arthur.SourceLanguage
import com.codebrig.arthur.generator.SchemaGenerator
import com.codebrig.arthur.observe.ObservationConfig
import com.codebrig.arthur.observe.ObservedLanguages
import com.codebrig.arthur.schema.SchemaSegment
import org.junit.Test

import static org.junit.Assert.assertEquals

class GraknSchemaWriterTest extends ArthurTest {

    @Test
    void segmentedSchema() {
        def schemaGenerator = new SchemaGenerator(ObservationConfig.fullStructure())
        def goLanguage = schemaGenerator.observeLanguage(SourceLanguage.Go, new File("src/test/resources/same/program/"))
        def javaLanguage = schemaGenerator.observeLanguage(SourceLanguage.Java, new File("src/test/resources/same/program/"))
        def javascriptLanguage = schemaGenerator.observeLanguage(SourceLanguage.Javascript, new File("src/test/resources/same/program/"))
        def phpLanguage = schemaGenerator.observeLanguage(SourceLanguage.Php, new File("src/test/resources/same/program/"))
        def pythonLanguage = schemaGenerator.observeLanguage(SourceLanguage.Python, new File("src/test/resources/same/program/"))
        def rubyLanguage = schemaGenerator.observeLanguage(SourceLanguage.Ruby, new File("src/test/resources/same/program/"))
        def omniLanguage = ObservedLanguages.mergeLanguages(goLanguage, javaLanguage, javascriptLanguage, phpLanguage, pythonLanguage, rubyLanguage)
        def schemaWriter = new GraknSchemaWriter(omniLanguage, goLanguage, javaLanguage, javascriptLanguage, phpLanguage, pythonLanguage, rubyLanguage)

        def baseStructure = schemaWriter.getSegmentedSchemaDefinition(ObservationConfig.baseStructure().asArray())
        assertEquals(new File("src/test/resources/schema/segment_same", "Base_Structure.gql").text, baseStructure)
        def semanticRoles = schemaWriter.getSegmentedSchemaDefinition(SchemaSegment.SEMANTIC_ROLES)
        assertEquals(new File("src/test/resources/schema/segment_same", "Semantic_Roles.gql").text, semanticRoles)
    }
}