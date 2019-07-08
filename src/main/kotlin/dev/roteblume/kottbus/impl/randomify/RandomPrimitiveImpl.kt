package dev.roteblume.kottbus.impl.randomify

import dev.roteblume.kottbus.Primitive
import java.util.UUID

class RandomPrimitiveImpl : Primitive {
    override fun boolean(): Boolean = kotlin.random.Random.nextBoolean()
    override fun int(from: Int, until: Int): Int = kotlin.random.Random.nextInt(from = from, until = until)
    override fun uuid(): UUID = UUID.randomUUID()
    override fun double(from: Double, until: Double): Double =
        kotlin.random.Random.nextDouble(from = from, until = until)
    override fun float(): Float = kotlin.random.Random.nextFloat()
    override fun byteArray(size: Int): ByteArray = kotlin.random.Random.nextBytes(size)
    override fun byte(): Byte = kotlin.random.Random.nextBytes(1)[0]
}
