package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.ENV

class EnvSource : ConfigurationSource {
    override fun <T> get(field: FieldConfig<T>): T? {
        return field.parse(System.getenv(getEnvName(field)))
    }

    private fun <T> getEnvName(field: FieldConfig<T>) = field.name.replace(".", "_").toUpperCase()

    override val name = ENV
}
