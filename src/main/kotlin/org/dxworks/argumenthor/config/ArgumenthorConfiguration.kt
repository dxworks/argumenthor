package org.dxworks.argumenthor.config

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.impl.ArgsSource
import org.dxworks.argumenthor.config.sources.impl.EnvSource
import org.dxworks.argumenthor.config.sources.impl.PropertiesSource

/**
 * Configuration holder for Argumenthor containing field definitions and sources.
 *
 * This class manages the registration of configuration fields and sources.
 * Sources are queried in the order they are added when looking up values.
 *
 * @property fields List of field configurations defining the available configuration keys.
 */
class ArgumenthorConfiguration(
    val fields: List<FieldConfig<*>>
) {
    /**
     * Creates a configuration with the specified fields.
     *
     * @param fields Variable number of field configurations.
     */
    constructor(vararg fields: FieldConfig<*>) : this(fields.toList())

    /**
     * Map of registered configuration sources, keyed by source name.
     */
    val sources: MutableMap<String, ConfigurationSource> = mutableMapOf()

    /**
     * Configures the default sources: Args, Properties, and Env.
     *
     * This clears any existing sources and adds the three default sources
     * in priority order: command-line arguments, properties file, environment variables.
     */
    fun setDefaultSources() {
        sources.clear()
        addSource(ArgsSource())
        addSource(PropertiesSource())
        addSource(EnvSource())
    }

    /**
     * Adds a configuration source to this configuration.
     *
     * @param source The configuration source to add.
     */
    fun addSource(source: ConfigurationSource) {
        sources[source.name] = source
    }
}
