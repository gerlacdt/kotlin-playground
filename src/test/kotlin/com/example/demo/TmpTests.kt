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
        val result = myParseInt("5")
        assertEquals(5, result)
    }

    @Test
    fun parseIntFailingTest() {
        val result = myParseInt("abc")
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

    @Test
    fun test2() {
        val x = 10
        val s = "10"
        val result = when (x) {
            myParseInt(s) -> true
            else -> false
        }
        assertTrue(result)
    }

    @Test
    fun sumExtend() {
        val l = listOf(1,2,3,4)
        val result = l.sum()
        assertEquals(10, result)
    }

    @Test
    fun identifierTest() {
        assertEquals(true, isValidIdentifier("name"))   // true
        assertEquals(true, isValidIdentifier("_name"))  // true
        assertEquals(true, isValidIdentifier("_12"))    // true
        assertEquals(false, isValidIdentifier(""))       // false
        assertEquals(false, isValidIdentifier("012"))    // false
        assertEquals(false, isValidIdentifier("no$"))    // false
    }

    @Test
    fun emptyOrNullTest() {
        val s1: String? = null
        val s2: String? = ""
        assertTrue(s1.isEmptyOrNull())
        assertTrue(s2.isEmptyOrNull())

        val s3 = "   "
        assertFalse(s3.isEmptyOrNull())
    }

    @Test
    fun smartCastTest() {
        val s = "foo"
        val result1 = (s as? Int)    // null
        assertNull(result1)
        assertThrows(ClassCastException::class.java,  {
            println(s as Int?)    // exception
        })
    }

    @Test
    fun predicatesTest() {
        fun List<Int>.allNonZero() =  all { it != 0 }
        fun List<Int>.allNonZero1() =  none { it == 0 }
        fun List<Int>.allNonZero2() =  !any { it == 0 }

        fun List<Int>.containsZero() =  any { it == 0 }
        fun List<Int>.containsZero1() =  !all { it != 0 }
        fun List<Int>.containsZero2() =  !none { it == 0  }

        val list1 = listOf(1, 2, 3)
        assertTrue(list1.allNonZero())
        assertTrue(list1.allNonZero1())
        assertTrue(list1.allNonZero2())

        assertFalse(list1.containsZero())
        assertFalse(list1.containsZero1())
        assertFalse(list1.containsZero2())

        val list2 = listOf(0, 1, 2)
        assertFalse(list2.allNonZero())
        assertFalse(list2.allNonZero1())
        assertFalse(list2.allNonZero2())

        assertTrue(list2.containsZero())
        assertTrue(list2.containsZero1())
        assertTrue(list2.containsZero2())
    }

    @Test
    fun foldTest() {
        val items = listOf(1, 2, 3, 4, 5)
        val result = items.fold(0, {
            acc: Int, i: Int ->
            val result = acc + i
            result
        })
        assertEquals(15, result)
    }

    @Test
    fun differentTest() {
        // The values should be different:
        println(different)
        println(different)
        println(different)
    }

    @Test
    fun lateInitTest() {
        val a = A()
        a.setUp()
        a.display()
    }

    @Test
    fun npeTest() {
        B("a")
    }

    @Test
    fun equalsTest() {
        assertTrue(equals1(Value("abc"), Value("abc")))
        assertFalse(equals1(Value("abc"), null))
        assertFalse(equals1(null, Value("abc")))
        assertTrue(equals1(null, null))

        assertTrue(equals2(Value("abc"), Value("abc")))
        assertFalse(equals2(Value("abc"), null))
        assertFalse(equals2(null, Value("abc")))
        assertTrue(equals2(null, null))
    }

}


