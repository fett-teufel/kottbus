package dev.roteblume.kottbus

interface Address {
    fun street(): String
    fun postCode(): String
    fun city(): String
    fun country(): String
    fun flat(): Int
    fun house(): String
    fun floor(): String
}
