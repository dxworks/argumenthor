package org.dxworks.argumenthor.config

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.impl.ArgsSource
import org.dxworks.argumenthor.config.sources.impl.EnvSource
import org.dxworks.argumenthor.config.sources.impl.PropertiesSource

class ArgumenthorConfiguration(
    val fields: List<FieldConfig<*>>
) {
    constructor(vararg fields: FieldConfig<*>) : this(fields.toList())

    val sources: MutableMap<String, ConfigurationSource> = mutableMapOf()

    fun setDefaultSources() {
        sources.clear()
        addSource(ArgsSource())
        addSource(PropertiesSource())
        addSource(EnvSource())
    }

    fun addSource(source: ConfigurationSource) {
        sources[source.name] = source
    }
}
