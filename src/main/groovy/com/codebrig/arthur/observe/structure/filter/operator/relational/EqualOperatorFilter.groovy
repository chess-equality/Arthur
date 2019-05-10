package com.codebrig.arthur.observe.structure.filter.operator.relational

import com.codebrig.arthur.SourceLanguage
import com.codebrig.arthur.SourceNode
import com.codebrig.arthur.observe.structure.StructureFilter
import com.codebrig.arthur.observe.structure.filter.MultiFilter
import com.codebrig.arthur.observe.structure.filter.RoleFilter

/**
 * Match by equal operator
 *
 * @version 0.4
 * @since 0.3
 * @author <a href="mailto:brandon.fergerson@codebrig.com">Brandon Fergerson</a>
 */
class EqualOperatorFilter extends StructureFilter<EqualOperatorFilter, Void> {

    private final MultiFilter equalOperatorFilter

    EqualOperatorFilter() {
        super()
        this.equalOperatorFilter = createEqualOperatorFilter()
    }

    private static createEqualOperatorFilter() {
        MultiFilter equalToken1Filter = MultiFilter.matchAll(
                new RoleFilter("EQUAL"), new RoleFilter("OPERATOR"), new RoleFilter("RELATIONAL")
        )
        MultiFilter equalToken2Filter = MultiFilter.matchAll(equalToken1Filter,
                new RoleFilter("EXPRESSION"), new RoleFilter("BINARY")
        )
        MultiFilter equalToken3Filter = MultiFilter.matchAll(equalToken1Filter, equalToken2Filter,
                new RoleFilter("IF"), new RoleFilter("CONDITION")
        )
        return MultiFilter.matchAny(equalToken1Filter, equalToken2Filter, equalToken3Filter)
    }

    @Override
    boolean evaluate(SourceNode node) {
        boolean result = this.equalOperatorFilter.evaluate(node)
        if (result) {
            if (node.language == SourceLanguage.Php) {
                return true
            } else {
                return node.token == "=="
            }
        }
        return false
    }
}
