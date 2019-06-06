package com.example.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TmpTests {

    @Test
    fun sumTest() {
        val result = sum(3, 3)
        assertEquals(6, result)
    }

    @Test
    fun subtractTest() {
        val result = subtract(4, 2)
        assertEquals(2, result)
    }

    @Test
    fun maxOfTest() {
        val result = maxOf(3, 7)
        assertEquals(7, result)
    }

    @Test
    fun parseIntTest() {
        val result = parseInt("5")
        assertEquals(5, result)
    }

    @Test
    fun parseIntFailingTest() {
        val result = parseInt("abc")
        assertEquals(null, result)
    }
}
