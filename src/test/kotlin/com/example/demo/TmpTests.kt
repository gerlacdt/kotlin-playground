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

    @Test
    fun fruitsTest() {
        fruits()
    }

    @Test
    fun describeTest() {
        val result = describe("Hello")
        assertEquals("Greeting", result)
    }

    @Test
    fun sumOfSquaresTest() {
        val result = sumOfSquares(listOf(1,2,3,4))
        assertEquals(30, result)
    }

    @Test
    fun filterTest() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        val result = fruits
            .filter { it.startsWith("a") }
            .sortedBy { it.length }
            .map { it.toUpperCase() }
        assertEquals(listOf("APPLE", "AVOCADO"), result)
    }

    @Test
    fun PersonTest() {
        val p = Person("first", "last", 18)

        assertEquals(18, p.age)
        assertEquals("first", p.firstname)
    }

    @Test
    fun pairsTest() {
        val result = withPairs(10, 1)
        assertEquals(Pair(1, 10), result)
    }
}


