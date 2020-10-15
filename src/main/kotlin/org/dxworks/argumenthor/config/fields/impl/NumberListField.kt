package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.utils.unaryPlus

class NumberListField(name: String, defaultValue: List<Number> = emptyList(), private val separator: String) :
    FieldConfig<List<Number>>(name, defaultValue) {
    override fun parse(value: String?): List<Number>? {
        return value?.split(separator)?.mapNotNull { +it }
    }
}
