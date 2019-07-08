package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Address
import dev.roteblume.kottbus.Generator
import dev.roteblume.kottbus.ID
import dev.roteblume.kottbus.Person
import dev.roteblume.kottbus.Primitive
import dev.roteblume.kottbus.Strings

class RandomGenerator(
    private val strings: Strings = RandomStringsImpl(),
    private val ids: ID = RandomIDImpl(),
    private val persons: Person = RandomPersonImpl(),
    private val addresses: Address = RandomAddressImpl(),
    private val primitive: Primitive = RandomPrimitiveImpl()
) : Generator {
    override fun strings(): Strings = strings
    override fun person(): Person = persons
    override fun address(): Address = addresses
    override fun id(): ID = ids
    override fun primitive(): Primitive = primitive
}
