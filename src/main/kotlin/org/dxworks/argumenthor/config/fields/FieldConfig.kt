package org.dxworks.argumenthor.config.fields

/**
 * Base class for configuration field definitions.
 *
 * A field configuration defines a named configuration key with a specific type
 * and optional default value. Subclasses implement the parsing logic to convert
 * string values to the target type.
 *
 * @param T The type of value this field holds.
 * @property name The name/key of this configuration field.
 * @property defaultValue Optional default value when the field is not found in any source.
 */
abstract class FieldConfig<T>(
    val name: String,
    val defaultValue: T? = null
) {
    /**
     * Parses a string value into the target type.
     *
     * @param value The string value to parse, may be null.
     * @return The parsed value, or null if parsing fails or input is null.
     */
    abstract fun parse(value: String?): T?
}

