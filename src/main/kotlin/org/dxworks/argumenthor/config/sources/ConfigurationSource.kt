package org.dxworks.argumenthor.config.sources

import org.dxworks.argumenthor.config.fields.FieldConfig

interface ConfigurationSource {
    fun <T> get(field: FieldConfig<T>): T?
    val name: String
}
