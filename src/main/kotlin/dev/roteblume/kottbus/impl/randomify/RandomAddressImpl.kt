package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Address
import dev.roteblume.kottbus.Strings

class RandomAddressImpl(
    private val streets: Strings = RandomStringsImpl(),
    private val cities: Strings = RandomStringsImpl(),
    private val countries: Strings = RandomStringsImpl()
) : Address {
    override fun street(): String = streets.string()

    override fun postCode(): String = kotlin.random.Random.nextInt(from = 666000, until = 777000).toString()

    override fun city(): String = cities.string()

    override fun country(): String = countries.string()

    override fun flat(): Int = kotlin.random.Random.nextInt(from = 1, until = 900)

    override fun house(): String = kotlin.random.Random.nextInt(from = 1, until = 100).toString()

    override fun floor(): String = kotlin.random.Random.nextInt(from = 1, until = 24).toString()
}
