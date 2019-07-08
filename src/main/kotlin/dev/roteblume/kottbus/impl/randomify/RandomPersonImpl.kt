package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Person
import dev.roteblume.kottbus.Strings

class RandomPersonImpl(
    private val names: Strings = RandomStringsImpl(),
    private val lastNames: Strings = RandomStringsImpl()
) : Person {
    override fun name(): String = names.string().capitalize()

    override fun lastName(): String = lastNames.string().capitalize()

    override fun firstName(): String = name()

    override fun middleName(): String = name()
}
