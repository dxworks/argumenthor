package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ARGS
import org.dxworks.argumenthor.config.sources.ConfigurationSource

class ArgsSource : ConfigurationSource {
    var args = emptyArray<String>()
    var argFormat = "-%s="
    var argNameFormatter: (name: String) -> String =
        { it.split(".").joinToString("", transform = String::capitalize).decapitalize() }

    override fun <T> get(field: FieldConfig<T>): T? {
        return args.let { a ->
            val prefix = String.format(argFormat, argNameFormatter(field.name))
            a.find { it.startsWith(prefix) }?.removePrefix(prefix)
        }?.let(field::parse)
    }

    override val name = ARGS
}
