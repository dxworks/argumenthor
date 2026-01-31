package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.ENV

/**
 * Configuration source that reads values from environment variables.
 *
 * Field names are converted to environment variable format: dots become underscores,
 * and the name is uppercased. An optional prefix can be added to all variable names.
 *
 * Example: field "db.host" with prefix "APP" becomes "APP_DB_HOST".
 *
 * @param prefix Optional prefix for environment variable names.
 */
class EnvSource(prefix: String = "") : ConfigurationSource {
    constructor() : this("")

    private val prefixString: String = if(prefix.isEmpty()) "" else prefix.uppercase() + "_"

    override fun <T> get(field: FieldConfig<T>): T? {
        return field.parse(System.getenv(getEnvName(field)))
    }

    private fun <T> getEnvName(field: FieldConfig<T>) = prefixString + field.name.replace(".", "_").uppercase()

    override val name = ENV
}
