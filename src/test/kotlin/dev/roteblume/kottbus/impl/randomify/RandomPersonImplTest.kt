package dev.roteblume.kottbus.impl.randomify

import com.nhaarman.mockitokotlin2.eq
import dev.roteblume.kottbus.Strings
import dev.roteblume.kottbus.testing.mockify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`

internal class RandomPersonImplTest {
    private lateinit var sut: RandomPersonImpl
    private lateinit var strings: Strings

    @BeforeEach
    fun tearUp() {
        strings = RandomStringsImpl()
        sut = RandomPersonImpl()
    }

    @Test
    fun `should be able generate name by default name-generator`() {
        val name = sut.name()
        assertEquals(10, name.length)
    }

    @Test
    fun `should be able generate name by specified name-generator`() {
        val names: Strings = mockify()
        val lastNames: Strings = mockify()
        val sut = RandomPersonImpl(names, lastNames)
        val expected = strings.string(10)

        `when`(names.string(eq(10))).then { expected }

        val name = sut.name()
        assertEquals(expected.capitalize(), name)
    }

    @Test
    fun `should be able generate name by default last name generator`() {
        val name = sut.lastName()
        assertEquals(10, name.length)
    }

    @Test
    fun `should be able generate name by specified last name-generator`() {
        val names: Strings = mockify()
        val lastNames: Strings = mockify()
        val sut = RandomPersonImpl(names, lastNames)
        val expected = strings.string(10)

        `when`(lastNames.string(eq(10))).then { expected }

        val name = sut.lastName()
        assertEquals(expected.capitalize(), name)
    }

    @Test
    fun `should be able generate name by default first name generator`() {
        val name = sut.firstName()
        assertEquals(10, name.length)
    }

    @Test
    fun `should be able generate name by specified first name-generator`() {
        val names: Strings = mockify()
        val lastNames: Strings = mockify()
        val sut = RandomPersonImpl(names, lastNames)
        val expected = strings.string(10)

        `when`(names.string(eq(10))).then { expected }

        val name = sut.firstName()
        assertEquals(expected.capitalize(), name)
    }

    @Test
    fun `should be able generate name by default middle name generator`() {
        val name = sut.middleName()
        assertEquals(10, name.length)
    }

    @Test
    fun `should be able generate name by specified first middle-generator`() {
        val names: Strings = mockify()
        val lastNames: Strings = mockify()
        val sut = RandomPersonImpl(names, lastNames)
        val expected = strings.string(10)

        `when`(names.string(eq(10))).then { expected }

        val name = sut.middleName()
        assertEquals(expected.capitalize(), name)
    }
}