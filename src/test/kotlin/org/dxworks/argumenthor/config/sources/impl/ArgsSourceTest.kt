package org.dxworks.argumenthor.config.sources.impl

import org.dxworks.argumenthor.Argumenthor
import org.dxworks.argumenthor.config.ArgumenthorConfiguration
import org.dxworks.argumenthor.config.fields.impl.StringListField
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ArgsSourceTest {

    @Test
    fun get() {
        val argsSource = ArgsSource().apply {
            args = "-arg1Arg2=asd,sdf"
        }

        val field = StringListField("arg1.arg2")
        val argumenthor = Argumenthor(ArgumenthorConfiguration(field).apply { addSource(argsSource) })

        val values: List<String> = argumenthor.getValue(field.name)!!
        assertEquals(2, values.size)
        assertTrue(values.containsAll(listOf("asd", "sdf")))
    }
}
