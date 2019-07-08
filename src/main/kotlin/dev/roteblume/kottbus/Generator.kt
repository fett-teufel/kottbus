package dev.roteblume.kottbus

interface Generator {
    fun strings(): Strings
    fun person(): Person
    fun address(): Address
    fun id(): ID
    fun primitive(): Primitive
}
