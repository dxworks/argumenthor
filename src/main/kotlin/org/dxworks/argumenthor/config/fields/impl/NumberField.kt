package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.utils.unaryPlus

/**
 * Field configuration for numeric values.
 *
 * Parses string values to numbers using Double conversion.
 *
 * @param name The name/key of this configuration field.
 * @param defaultValue Optional default value when the field is not found.
 */
class NumberField(name: String, defaultValue: Number? = null) : FieldConfig<Number>(name, defaultValue) {
    override fun parse(value: String?): Number? {
        return +value
    }
}


