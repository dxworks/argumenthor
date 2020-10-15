package org.dxworks.argumenthor.utils

operator fun String?.unaryPlus(): Number? {
    return this?.toDouble()
}
