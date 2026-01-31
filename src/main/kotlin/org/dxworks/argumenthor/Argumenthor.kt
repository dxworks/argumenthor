package org.dxworks.argumenthor

import org.dxworks.argumenthor.config.ArgumenthorConfiguration
import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.exception.NoSuchSourceException

/**
 * Main facade for retrieving configuration values from multiple sources.
 *
 * Argumenthor provides a unified interface to look up configuration values across
 * different sources (command-line arguments, properties files, environment variables)
 * with automatic type conversion and fallback to default values.
 *
 * @property configuration The configuration containing field definitions and sources.
 */
class Argumenthor(private val configuration: ArgumenthorConfiguration) {

    private val fields = configuration.fields.map { it.name to it }.toMap()

    /**
     * Retrieves a typed configuration value by name, searching all configured sources.
     *
     * @param T The expected type of the configuration value.
     * @param name The name of the field to retrieve.
     * @return The configuration value cast to type T, or null if not found.
     */
    inline fun <reified T> getValue(name: String) = getRawValue(name) as T?

    /**
     * Retrieves a typed configuration value by name from a specific source.
     *
     * @param T The expected type of the configuration value.
     * @param name The name of the field to retrieve.
     * @param source The name of the source to query.
     * @return The configuration value cast to type T, or null if not found.
     * @throws NoSuchSourceException if the specified source is not configured.
     */
    inline fun <reified T> getValue(name: String, source: String) = getRawValue(name, source) as T?

    /**
     * Retrieves a configuration value by name without type casting.
     *
     * @param name The name of the field to retrieve.
     * @return The raw configuration value, or the field's default value if not found.
     * @throws NoSuchFieldException if the field is not defined in the configuration.
     */
    fun getRawValue(name: String): Any? {
        return getValueOrDefault(fieldConfig(name))
    }

    /**
     * Retrieves a configuration value by name from a specific source without type casting.
     *
     * @param name The name of the field to retrieve.
     * @param source The name of the source to query.
     * @return The raw configuration value, or null if not found in the specified source.
     * @throws NoSuchFieldException if the field is not defined in the configuration.
     * @throws NoSuchSourceException if the specified source is not configured.
     */
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
