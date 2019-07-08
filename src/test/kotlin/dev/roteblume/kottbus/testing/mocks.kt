package dev.roteblume.kottbus.testing

import org.mockito.Mockito

inline fun <reified T : Any> mockify() = Mockito.mock(T::class.java)