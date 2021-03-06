# Arthur

[![Build Status](https://travis-ci.com/CodeBrig/Arthur.svg?branch=master)](https://travis-ci.com/CodeBrig/Arthur)

Arthur is a semantic language-agnostic UAST (universal abstract syntax tree) schema generator which uses source code as input and outputs unilingual and omnilingual ontologies derived from those language(s).
Arthur parses source code using [Babelfish](https://github.com/bblfsh/bblfshd) and constructs the observed schema for use in a [Grakn](https://github.com/graknlabs/grakn) knowledge graph. 

## Omnilingual Schema

| Languages                               | Segments                                                     |
| --------------------------------------- | ------------------------------------------------------------ |
| Go, Java, JavaScript, PHP, Python, Ruby | [Arthur_Omnilingual_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/omnilingual/Arthur_Omnilingual_Base_Structure.gql) <br> [Arthur_Omnilingual_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/omnilingual/Arthur_Omnilingual_Semantic_Roles.gql) |

## Unilingual Schemas

| Language   | Segments                                                     |
| ---------- | ------------------------------------------------------------ |
| Go         | [Arthur_Go_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/go/Arthur_Go_Base_Structure.gql) <br> [Arthur_Go_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/go/Arthur_Go_Semantic_Roles.gql) |
| Java       | [Arthur_Java_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/java/Arthur_Java_Base_Structure.gql) <br> [Arthur_Java_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/java/Arthur_Java_Semantic_Roles.gql) |
| JavaScript | [Arthur_Javascript_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/javascript/Arthur_Javascript_Base_Structure.gql) <br> [Arthur_Javascript_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/javascript/Arthur_Javascript_Semantic_Roles.gql) |
| PHP        | [Arthur_Php_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/php/Arthur_Php_Base_Structure.gql) <br> [Arthur_Php_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/php/Arthur_Php_Semantic_Roles.gql) |
| Python     | [Arthur_Python_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/python/Arthur_Python_Base_Structure.gql) <br> [Arthur_Python_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/python/Arthur_Python_Semantic_Roles.gql) |
| Ruby       | [Arthur_Ruby_Base_Structure.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/ruby/Arthur_Ruby_Base_Structure.gql) <br> [Arthur_Ruby_Semantic_Roles.gql](https://github.com/CodeBrig/Arthur/blob/master/src/main/resources/schema/unilingual/ruby/Arthur_Ruby_Semantic_Roles.gql) |
