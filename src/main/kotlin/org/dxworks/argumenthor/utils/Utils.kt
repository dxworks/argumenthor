package org.dxworks.argumenthor.utils

/**
 * Converts a nullable string to a number using the unary plus operator.
 *
 * @return The string parsed as a Double, or null if the string is null or cannot be parsed.
 */
operator fun String?.unaryPlus(): Number? {
    return this?.toDouble()
}
