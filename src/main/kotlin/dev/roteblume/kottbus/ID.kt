package dev.roteblume.kottbus

import java.util.UUID

interface ID {
    fun uuid(): UUID
    fun serial(): Int
    fun string(): String
}
