package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.ENV

class EnvSource(prefix: String = "") : ConfigurationSource {
    constructor() : this("")

    private val prefixString: String = if(prefix.isEmpty()) "" else prefix + "_"

    override fun <T> get(field: FieldConfig<T>): T? {
        return field.parse(System.getenv(getEnvName(field)))
    }

    private fun <T> getEnvName(field: FieldConfig<T>) = prefixString + field.name.replace(".", "_").toUpperCase()

    override val name = ENV
}
