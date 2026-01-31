package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig

/**
 * Field configuration for lists of string values.
 *
 * Parses a delimited string into a list of strings.
 *
 * @param name The name/key of this configuration field.
 * @param defaultValue Default value when the field is not found, defaults to empty list.
 * @param separator The delimiter used to split the string, defaults to comma.
 */
class StringListField(name: String, defaultValue: List<String> = emptyList(), private val separator: String = ",") :
    FieldConfig<List<String>>(name, defaultValue) {
    override fun parse(value: String?): List<String>? {
        return value?.split(separator)
    }
}
