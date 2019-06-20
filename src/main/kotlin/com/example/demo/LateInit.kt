package com.example.demo

class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}