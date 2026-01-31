package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.config.fields.FieldConfig
import org.dxworks.argumenthor.config.sources.ARGS
import org.dxworks.argumenthor.config.sources.ConfigurationSource

/**
 * Configuration source that reads values from command-line arguments.
 *
 * Arguments are expected in the format `-argName=value` by default.
 * The argument name is derived from the field name using camelCase conversion.
 */
class ArgsSource : ConfigurationSource {
    /**
     * The command-line arguments array to search.
     */
    var args = emptyArray<String>()

    /**
     * Format string for argument matching. Default is "-%s=" which matches "-argName=value".
     */
    var argFormat = "-%s="

    /**
     * Function to transform field names to argument names.
     * Default converts "some.field.name" to "someFieldName".
     */
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
