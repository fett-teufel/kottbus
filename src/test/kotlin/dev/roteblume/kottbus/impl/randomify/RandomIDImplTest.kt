package dev.roteblume.kottbus.impl.randomify

import com.nhaarman.mockitokotlin2.eq
import dev.roteblume.kottbus.ID
import dev.roteblume.kottbus.Strings
import dev.roteblume.kottbus.testing.mockify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import java.util.concurrent.atomic.AtomicInteger

internal class RandomIDImplTest {
    private lateinit var sut: ID
    private val defaultStrings = RandomStringsImpl()

    @BeforeEach
    fun tearUp() {
        sut = RandomIDImpl(strings = defaultStrings)
    }

    @Test
    fun `should be able generate random UUID id`() {
        val uuid = sut.uuid()
        assertEquals(4, uuid.version())
    }

    @Test
    fun `should be able generate random serial id by default seed`() {
        val int = sut.serial()
        assertEquals(1, int)
    }

    @Test
    fun `should be able generate random serial id by specified seed`() {
        val seed = kotlin.random.Random.nextInt()
        val sut = RandomIDImpl(seedSerial = AtomicInteger(seed))
        val int = sut.serial()
        assertEquals(seed + 1, int)
    }

    @Test
    fun `should be able generate random string by default strings generator`() {
        val id = sut.string()
        assertEquals(10, id.length)
    }

    @Test
    fun `should be able generate random string by specified strings generator`() {
        val strings: Strings = mockify()
        val sut = RandomIDImpl(strings = strings)
        val expect = defaultStrings.string(11)
        `when`(strings.string(eq(10))).then { expect }
        assertEquals(expect.toUpperCase(), sut.string())
    }
}
