package org.dxworks.argumenthor.exception

/**
 * Exception thrown when attempting to access a configuration source that has not been registered.
 *
 * @param s The error message describing which source was not found.
 */
class NoSuchSourceException(s: String) : RuntimeException(s)
