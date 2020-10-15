package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.PROPERTIES
import java.nio.file.Paths
import java.util.*

class PropertiesSource : ConfigurationSource {
    var path = "config.properties"
    var charset = Charsets.UTF_8
    private var properties: Properties? = null

    override fun <T> get(field: FieldConfig<T>): T? {
        if (properties == null) {
            try {
                properties = Properties().apply {
                    load(Paths.get(path).toFile().reader(charset))
                }
            } catch (e: Exception) {
                return null
            }
        }
        return properties?.getProperty(field.name)?.let(field::parse)
    }

    override val name = PROPERTIES
}
