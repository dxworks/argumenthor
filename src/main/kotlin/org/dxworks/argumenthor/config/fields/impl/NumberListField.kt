package org.dxworks.argumenthor.config.fields.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.utils.unaryPlus

/**
 * Field configuration for lists of numeric values.
 *
 * Parses a delimited string into a list of numbers. Non-numeric entries are skipped.
 *
 * @param name The name/key of this configuration field.
 * @param defaultValue Default value when the field is not found, defaults to empty list.
 * @param separator The delimiter used to split the string.
 */
class NumberListField(name: String, defaultValue: List<Number> = emptyList(), private val separator: String) :
    FieldConfig<List<Number>>(name, defaultValue) {
    override fun parse(value: String?): List<Number>? {
        return value?.split(separator)?.mapNotNull { +it }
    }
}
