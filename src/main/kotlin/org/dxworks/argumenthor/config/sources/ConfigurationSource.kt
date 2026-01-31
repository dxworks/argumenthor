package org.dxworks.argumenthor.config.sources

import org.dxworks.argumenthor.config.fields.FieldConfig

/**
 * Interface for configuration value sources.
 *
 * Implementations provide access to configuration values from different backends
 * such as command-line arguments, properties files, environment variables, etc.
 */
interface ConfigurationSource {
    /**
     * Retrieves a configuration value for the specified field.
     *
     * @param T The type of value to retrieve.
     * @param field The field configuration describing the value to look up.
     * @return The parsed value, or null if not found in this source.
     */
    fun <T> get(field: FieldConfig<T>): T?

    /**
     * The unique name identifying this source.
     */
    val name: String
}
