package dev.roteblume.kottbus.impl.randomify

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RandomPrimitiveImplTest {

    private lateinit var sut: RandomPrimitiveImpl

    @BeforeEach
    fun tearUp() {
        sut = RandomPrimitiveImpl()
    }

    @Test
    fun `should be able generate boolean`() {
        sut.boolean()
    }

    @Test
    fun `should be able generate integer in default range`() {
        assertTrue { sut.int() in 0..1000 }
    }

    @Test
    fun `should be able generate integer in specify range`() {
        assertTrue { sut.int(from = 1, until = 5) in 1..5 }
    }

    @Test
    fun `should be able generate uuid`() {
        assertEquals(4, sut.uuid().version())
    }

    @Test
    fun `should be able double in default range`() {
        assertTrue { sut.double() in 0.0..1000.0 }
    }

    @Test
    fun `should be able double in specified range`() {
        assertTrue { sut.double(from = 1.0, until = 2.0) in 1.0..2.0 }
    }

    @Test
    fun `should be able generate float`() {
        sut.float()
    }

    @Test
    fun `should be able generate byte array by default size`() {
        assertEquals(8, sut.byteArray().size)
    }

    @Test
    fun `should be able generate byte array by specified size`() {
        assertEquals(2, sut.byteArray(size = 2).size)
    }

    @Test
    fun `should be able generate byte`() {
        sut.byte()
    }
}