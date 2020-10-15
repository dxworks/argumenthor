package org.dxworks.argumenthor

import org.dxworks.argumenthor.config.ArgumenthorConfiguration
import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.exception.NoSuchSourceException

class Argumenthor(private val configuration: ArgumenthorConfiguration) {

    private val fields = configuration.fields.map { it.name to it }.toMap()

    inline fun <reified T> getValue(name: String) = getRawValue(name) as T?

    inline fun <reified T> getValue(name: String, source: String) = getRawValue(name, source) as T?

    fun getRawValue(name: String): Any? {
        return getValueOrDefault(fieldConfig(name))
    }

    fun getRawValue(name: String, source: String): Any? {
        return configurationSource(source).get(fieldConfig(name))
    }

    private fun fieldConfig(name: String) =
        (fields[name] ?: throw NoSuchFieldException("Field $name was not declared in config"))

    private fun configurationSource(source: String) =
        configuration.sources[source] ?: throw NoSuchSourceException("Source $source was not declared in config")

    private fun getValueOrDefault(fieldConfig: FieldConfig<*>) =
        (configuration.sources.mapNotNull { it.value.get(fieldConfig) }.firstOrNull()
            ?: fieldConfig.defaultValue)
}
