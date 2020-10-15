package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig

class StringListField(name: String, defaultValue: List<String> = emptyList(), private val separator: String = ",") :
    FieldConfig<List<String>>(name, defaultValue) {
    override fun parse(value: String?): List<String>? {
        return value?.split(separator)
    }
}
