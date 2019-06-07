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

fun myParseInt(str: String): Int? {
	try {
		return str.toInt()
	} catch (e: RuntimeException) {
		return null
	}
}

fun fruits(): Unit {
	val items = listOf("apple", "banana", "kiwifruit")
	for (item in items) {
		println(item)
	}
}

fun describe(obj: Any): String =
	when (obj) {
		1          -> "One"
		"Hello"    -> "Greeting"
		is Long    -> "Long"
		!is String -> "Not a string"
		else       -> "Unknown"
	}


fun sumOfSquares(lst: List<Int>): Int {
	return lst.reduce { acc: Int, x: Int ->	acc + x*x }
}


fun withPairs(a: Int, b: Int): Pair<Int, Int> {
	// val p = Pair(1, 2)
	val p = if (a < b) a to b else b to a
	return p

}