package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.utils.unaryPlus

class NumberField(name: String, defaultValue: Number? = null) : FieldConfig<Number>(name, defaultValue) {
    override fun parse(value: String?): Number? {
        return +value
    }
}


