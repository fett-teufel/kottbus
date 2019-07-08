package dev.roteblume.kottbus.impl.randomify

import com.nhaarman.mockitokotlin2.eq
import dev.roteblume.kottbus.Address
import dev.roteblume.kottbus.Strings
import dev.roteblume.kottbus.testing.mockify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`

internal class RandomAddressImplTest {
    private lateinit var sut: Address
    private var strings: Strings = RandomStringsImpl()
    private var gen: Strings = mockify()

    @BeforeEach
    fun tearUp() {
        sut = RandomAddressImpl()
    }

    @Test
    fun `should be able generate street from default street generator`() {
        val street = sut.street()
        assertEquals(10, street.length)
    }

    @Test
    fun `should be able generate street from specified street generator`() {
        val expect = strings.string()
        val sut = RandomAddressImpl(streets = gen)

        `when`(gen.string(eq(10))).then { expect }

        val streetName = sut.street()
        assertEquals(expect, streetName)
    }

    @Test
    fun `should be able generate city from default cities generator`() {
        val cityName = sut.city()
        assertEquals(10, cityName.length)
    }

    @Test
    fun `should be able generate city from specified cities generator`() {
        val expect = strings.string()
        val sut = RandomAddressImpl(cities = gen)

        `when`(gen.string(eq(10))).then { expect }

        val cityName = sut.city()
        assertEquals(expect, cityName)
    }

    @Test
    fun `should be able generate country from default countries generator`() {
        val country = sut.country()
        assertEquals(10, country.length)
    }

    @Test
    fun `should be able generate country from specified countries generator`() {
        val expect = strings.string()
        val sut = RandomAddressImpl(countries = gen)

        `when`(gen.string(eq(10))).then { expect }

        val countryame = sut.country()
        assertEquals(expect, countryame)
    }

    @Test
    fun `should be able generate postal code`() {
        val code = sut.postCode().toInt()
        assertTrue { code in 666000..777000 }
    }

    @Test
    fun `should be able generate flat number`() {
        val number = sut.flat()
        assertTrue { number in 1..900 }
    }

    @Test
    fun `should be able generate house number`() {
        val number = sut.house().toInt()
        assertTrue { number in 1..100 }
    }

    @Test
    fun `should be able generate floor number`() {
        val number = sut.floor().toInt()
        assertTrue { number in 1..24 }
    }
}