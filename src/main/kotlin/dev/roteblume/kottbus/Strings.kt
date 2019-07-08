package dev.roteblume.kottbus

interface Strings {
    fun string(length: Int = 10): String // length limited string
    fun text(lines: Int = 5, length: Int = 10): String // new-line separated text block
}
