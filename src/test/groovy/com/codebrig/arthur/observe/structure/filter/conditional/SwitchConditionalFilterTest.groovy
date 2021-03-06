package com.codebrig.arthur.observe.structure.filter.conditional

import com.codebrig.arthur.ArthurTest
import com.codebrig.arthur.SourceLanguage
import com.codebrig.arthur.observe.structure.filter.FunctionFilter
import com.codebrig.arthur.observe.structure.filter.MultiFilter
import com.codebrig.arthur.observe.structure.filter.NameFilter
import gopkg.in.bblfsh.sdk.v1.protocol.generated.Encoding
import org.junit.Test

import static org.junit.Assert.*

class SwitchConditionalFilterTest extends ArthurTest {

    @Test
    void switchConditional_Go() {
        def file = new File("src/test/resources/same/conditionals/Conditionals.go")
        def language = SourceLanguage.getSourceLanguage(file)
        def resp = client.parse(file.name, file.text, language.key, Encoding.UTF8$.MODULE$)

        def foundSwitchConditional = false
        def functionFilter = new FunctionFilter()
        def nameFilter = new NameFilter("switchConditional")
        MultiFilter.matchAll(functionFilter, nameFilter).getFilteredNodes(language, resp.uast).each {
            assertEquals("switchConditional()", it.name)

            new SwitchConditionalFilter().getFilteredNodes(it).each {
                assertFalse(foundSwitchConditional)
                foundSwitchConditional = true
            }
        }
        assertTrue(foundSwitchConditional)
    }

    @Test
    void switchConditional_Java() {
        def file = new File("src/test/resources/same/conditionals/Conditionals.java")
        def language = SourceLanguage.getSourceLanguage(file)
        def resp = client.parse(file.name, file.text, language.key, Encoding.UTF8$.MODULE$)

        def foundSwitchConditional = false
        def functionFilter = new FunctionFilter()
        def nameFilter = new NameFilter("switchConditional")
        MultiFilter.matchAll(functionFilter, nameFilter).getFilteredNodes(language, resp.uast).each {
            assertEquals("Conditionals.switchConditional()", it.name)

            new SwitchConditionalFilter().getFilteredNodes(it).each {
                assertFalse(foundSwitchConditional)
                foundSwitchConditional = true
            }
        }
        assertTrue(foundSwitchConditional)
    }

    @Test
    void switchConditional_Javascript() {
        def file = new File("src/test/resources/same/conditionals/Conditionals.js")
        def language = SourceLanguage.getSourceLanguage(file)
        def resp = client.parse(file.name, file.text, language.key, Encoding.UTF8$.MODULE$)

        def foundSwitchConditional = false
        def functionFilter = new FunctionFilter()
        def nameFilter = new NameFilter("switchConditional")
        MultiFilter.matchAll(functionFilter, nameFilter).getFilteredNodes(language, resp.uast).each {
            assertEquals("switchConditional()", it.name)

            new SwitchConditionalFilter().getFilteredNodes(it).each {
                assertFalse(foundSwitchConditional)
                foundSwitchConditional = true
            }
        }
        assertTrue(foundSwitchConditional)
    }
}