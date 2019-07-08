package dev.roteblume.kottbus

import java.util.UUID

interface Primitive {
    fun boolean(): Boolean
    fun int(from: Int = 0, until: Int = 1000): Int
    fun uuid(): UUID
    fun double(from: Double = 0.0, until: Double = 1000.0): Double
    fun float(): Float
    fun byteArray(size: Int = 8): ByteArray
    fun byte(): Byte
}
