package org.dxworks.argumenthor.config

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.impl.Env

class ArgumenthorConfiguration(
    val fields: List<FieldConfig<*>>
) {
    val sources: MutableMap<String, ConfigurationSource>

    init {
        val env = Env()
        sources = mutableMapOf(
            env.name to env
        )
    }
}
