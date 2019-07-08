package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Strings
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RandomStringsImplTest {
    private lateinit var sut: Strings

    @BeforeEach
    fun tearUp() {
        sut = RandomStringsImpl()
    }

    @Test
    fun `should be able generate string with default size`() {
        val result = sut.string()
        assertEquals(10, result.length)
    }

    @Test
    fun `should be able generate string with specified size`() {
        val expectedSize = 42
        val result = sut.string(length = 42)
        assertEquals(expectedSize, result.length)
    }

    @Test
    fun `should be able generate string with random size`() {
        val expectedSize = kotlin.random.Random.nextInt(until = 100)
        val result = sut.string(length = expectedSize)
        assertEquals(expectedSize, result.length)
    }

    @Test
    fun `should be able generate text string with default size`() {
        val result = sut.text()
        val lines = result.split("\n")
        assertEquals(5, lines.size)
        lines.forEach {
            assertTrue {
                it.length == 10
            }
        }
    }

    @Test
    fun `should be able generate text string with specified lines`() {
        val expectedLines = 15
        val result = sut.text(lines = expectedLines)
        val lines = result.split("\n")
        assertEquals(expectedLines, lines.size)
        lines.forEach {
            assertTrue {
                it.length == 10
            }
        }
    }

    @Test
    fun `should be able generate text string with specified line length`() {
        val expectedLength = 15
        val result = sut.text(length = expectedLength)
        val lines = result.split("\n")
        assertEquals(5, lines.size)
        lines.forEach {
            assertTrue {
                it.length == expectedLength
            }
        }
    }

    @Test
    fun `should be able generate text string with specified lines and lines length`() {
        val expectedLength = 15
        val expectedLines = 17
        val result = sut.text(length = expectedLength, lines = expectedLines)
        val lines = result.split("\n")
        assertEquals(expectedLines, lines.size)
        lines.forEach {
            assertTrue {
                it.length == expectedLength
            }
        }
    }

    @Test
    fun `should be able generate text string with random parameters`() {
        val expectedLength = kotlin.random.Random.nextInt(until = 42)
        val expectedLines = kotlin.random.Random.nextInt(until = 100)
        val result = sut.text(length = expectedLength, lines = expectedLines)
        val lines = result.split("\n")
        assertEquals(expectedLines, lines.size)
        lines.forEach {
            assertTrue {
                it.length == expectedLength
            }
        }
    }
}