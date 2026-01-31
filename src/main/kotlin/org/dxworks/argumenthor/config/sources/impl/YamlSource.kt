package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.YAML

/**
 * Configuration source for YAML files.
 *
 * Note: This source is not yet implemented and always returns null.
 */
class YamlSource : ConfigurationSource {
    /**
     * Path to the YAML configuration file.
     */
    var path = "config.yaml"

    override fun <T> get(field: FieldConfig<T>): T? {
        return null
    }

    override val name = YAML
}
