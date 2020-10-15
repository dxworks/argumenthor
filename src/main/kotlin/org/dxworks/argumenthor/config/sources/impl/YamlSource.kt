package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ConfigurationSource
import org.dxworks.argumenthor.config.sources.YAML

class YamlSource : ConfigurationSource {
    var path = "config.yaml"

    override fun <T> get(field: FieldConfig<T>): T? {
        return null
    }

    override val name = YAML


}
