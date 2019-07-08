package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Address
import dev.roteblume.kottbus.ID
import dev.roteblume.kottbus.Person
import dev.roteblume.kottbus.Strings
import dev.roteblume.kottbus.testing.mockify
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RandomGeneratorTest {
    @Test
    fun `should be able create random generator with base generators`() {
        val gen = RandomGenerator()
        assertDoesNotThrow { gen.strings() as RandomStringsImpl }
        assertDoesNotThrow { gen.id() as RandomIDImpl }
        assertDoesNotThrow { gen.person() as RandomPersonImpl }
        assertDoesNotThrow { gen.address() as RandomAddressImpl }
        assertDoesNotThrow { gen.primitive() as RandomPrimitiveImpl }
    }

    @Test
    fun `should be able create specified strings generator with base generators`() {
        val exp: Strings = mockify()
        val gen = RandomGenerator(strings = exp)
        val str = gen.strings()
        assertEquals(exp, str)
    }

    @Test
    fun `should be able create specified ids generator with base generators`() {
        val exp: ID = mockify()
        val gen = RandomGenerator(ids = exp)
        val str = gen.id()
        assertEquals(exp, str)
    }

    @Test
    fun `should be able create specified person generator with base generators`() {
        val exp: Person = mockify()
        val gen = RandomGenerator(persons = exp)
        val str = gen.person()
        assertEquals(exp, str)
    }

    @Test
    fun `should be able create specified address generator with base generators`() {
        val exp: Address = mockify()
        val gen = RandomGenerator(addresses = exp)
        val str = gen.address()
        assertEquals(exp, str)
    }
}