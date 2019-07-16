package com.example.demo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class TaxicabTests {

    @Test
    fun integersTest() {
        val ints = integers()
        val lst1 = ints.take(5).toList()
        val lst2 = ints.take(5).toList()

        assertEquals(lst1, lst2)
    }

    @Test
    fun fibTest() {
        val fibs = fib().take(10).toList()
        val expected = listOf<Int>(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
       assertEquals(expected, fibs)
    }

    @Test
    fun primesTest() {
        val result = primes.take(10).toList()
        val result2 = primes2.take(10).toList()
        val expected = listOf<Int>(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
        assertEquals(expected, result)
        assertEquals(expected, result2)
    }

    @Test
    fun weightedPairsTest() {
        val pairs = weightedPairs(integers(), integers()) { cubeWeight(it)}
        val result = pairs.take(4).toList()
        println(result)
    }
}