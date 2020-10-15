package org.dxworks.argumenthor.config.fields

abstract class FieldConfig<T>(
    val name: String,
    val defaultValue: T? = null
) {
    abstract fun parse(value: String?): T?
}

