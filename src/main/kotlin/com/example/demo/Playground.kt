package com.example.demo

import kotlin.coroutines.*

open class A1(val value: String) {
    init {
        println(value.length)
    }
}

class B(value: String) : A1(value)


data class Value(val s: String)

fun equals1(v1: Value?, v2: Value?): Boolean {
    return v1 == v2
}

fun equals2(v1: Value?, v2: Value?): Boolean = v1?.equals(v2) ?: (v2 === null)

fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val destination = ArrayList<Int>()
    for (element in list) {
        if (element != 0) {
            destination.add(element)
        }
    }
    return destination
}

fun fibonacci(): Sequence<Int> = sequence {
    yield(0)
    yield(1)
    var first = 0
    var second = 1
    while (true) {
        var result = first + second
        val tmp = second
        first =  second
        second = result
        yield(result)
    }
}

interface X {
    var first: Int
    var second: Int
    var third: Int
}

interface Y {
    fun start()
    fun finish()
}

interface Z {
    fun init()
}

fun foo(x: X, y: Y?, z: Z) {
    with(x) {
        first = 1
        second = 2
        third = 3
    }
    y?.run {
        start()
        finish()
    }
    val result: Z = z.apply {
        init()
    }
}

class Words {
    private val list = mutableListOf<String>()

    operator fun String.unaryPlus() {
        list.add(this)
    }

    fun String.record() {
        list.add(this)
    }

    override fun toString() = list.toString()
}
