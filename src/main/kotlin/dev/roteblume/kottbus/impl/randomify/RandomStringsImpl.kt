package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Strings

class RandomStringsImpl(
    private val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
) : Strings {
    override fun string(length: Int): String = (1..length)
        .map { alphabet[kotlin.random.Random.nextInt(0, alphabet.size)] }
        .joinToString(separator = "")

    override fun text(lines: Int, length: Int): String = (1..lines).joinToString(separator = "\n") { string(length) }
}
