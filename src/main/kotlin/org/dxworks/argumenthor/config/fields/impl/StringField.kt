package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig

class StringField(name: String, defaultValue: String? = null) : FieldConfig<String>(name, defaultValue) {
    override fun parse(value: String?): String? {
        return value
    }
}
