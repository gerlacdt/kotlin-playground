package com.example.demo

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