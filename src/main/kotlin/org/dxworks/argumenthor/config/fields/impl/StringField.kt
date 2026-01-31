package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig

/**
 * Field configuration for string values.
 *
 * Parses string values with automatic trimming of surrounding quotes (single or double).
 *
 * @param name The name/key of this configuration field.
 * @param defaultValue Optional default value when the field is not found.
 */
class StringField(name: String, defaultValue: String? = null) : FieldConfig<String>(name, defaultValue) {
    override fun parse(value: String?): String? {
        return value?.trim('\"', '\'')
    }
}
