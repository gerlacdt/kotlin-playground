package com.example.demo

class DemoApplication

fun main(args: Array<String>) {
	print("Hello World")
}

fun sum(a: Int, b: Int): Int {
	return a + b
}

fun subtract(a: Int, b: Int) = a - b

fun maxOf(a: Int, b: Int): Int {
	if (a > b) {
		return a
	} else {
		return b
	}
}

fun parseInt(str: String): Int? {
	try {
		return str.toInt()
	} catch (e: RuntimeException) {
		return null
	}
}