package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.ID
import dev.roteblume.kottbus.Strings
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger

class RandomIDImpl(
    private val strings: Strings = RandomStringsImpl(),
    private val seedSerial: AtomicInteger = AtomicInteger(0)
) : ID {
    override fun uuid(): UUID = UUID.randomUUID()

    override fun serial(): Int = seedSerial.incrementAndGet()

    override fun string(): String = strings.string().toUpperCase()

}
