package com.example.demo


fun integers(): Sequence<Int> = generateSequence(1) { it + 1 }

fun fib() = generateSequence(1 to 1) { it.second to it.first + it.second }.map { it.first }

val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
    val currSeq = it.second.iterator()
    val nextPrime = currSeq.next()
    nextPrime to currSeq.asSequence().filter { it % nextPrime != 0 }
}.map { it.first }


// https://agilewombat.com/2016/02/06/kotlin-sequences/
operator fun <T> Sequence<T>.plus(otherGenerator: () -> Sequence<T>) =
        object : Sequence<T> {
            private val thisIterator: Iterator<T> by lazy { this@plus.iterator() }
            private val otherIterator: Iterator<T> by lazy { otherGenerator().iterator() }

            override fun iterator() = object : Iterator<T> {
                override fun next(): T =
                        if (thisIterator.hasNext())
                            thisIterator.next()
                        else
                            otherIterator.next()

                override fun hasNext(): Boolean = thisIterator.hasNext() || otherIterator.hasNext()
            }
        }


fun primesFilter(from: Sequence<Int>): Sequence<Int> = from.iterator().let {
    val current = it.next()
    sequenceOf(current) + { primesFilter(it.asSequence().filter { it % current != 0 }) }
}

val primes2 = primesFilter(generateSequence(2) {it + 1})


// ramanujan numbers
fun cube(n: Int): Int = n * n * n

fun cubeWeight(p: Pair<Int, Int>): Int = cube(p.first) + cube(p.second)


fun mergeWeighted(s1: Sequence<Pair<Int, Int>>, s2: Sequence<Pair<Int, Int>>,
                  weightFn: (pair: Pair<Int, Int>) -> Int): Sequence<Pair<Int, Int>> {
    if (!s1.iterator().hasNext()) {
        return s2
    }
    if (!s2.iterator().hasNext()) {
        return s1
    }
    val s1car = s1.first()
    val s2car = s2.first()
    println("mergeWeighted: $s1car $s2car")
    if (weightFn(s1car) <= weightFn(s2car)) {
        println("in smaller")
        return sequenceOf(s1car) + { mergeWeighted(s1.drop(1), s2, weightFn) }
    } else {
        println("in bigger")
        return sequenceOf(s2car) + { mergeWeighted(s1, s2.drop(1), weightFn) }
    }
}

fun weightedPairs(s1: Sequence<Int>, s2: Sequence<Int>,
                  weightFn: (pair: Pair<Int, Int>) -> Int): Sequence<Pair<Int, Int>> {
    val s1car = s1.first()
    val s2car = s2.first()
    println("weightedPairs: $s1car $s2car")
    return sequenceOf(s1car to s2car) +
            { mergeWeighted(s2.drop(1).map { s1car to it }, weightedPairs(s1.drop(1), s2.drop(1), weightFn),
                    weightFn) }
}


fun pairs(): Sequence<Pair<Int, Int>> = sequence {
    var i = 1
    var j = 1
    while (true) {
        while (i <= j) {
            yield(i to j)
            i++
        }
        i = 1
        j++
    }
}

fun ramanujan(n: Int = 5): List<Int> {
    val ps = pairs().iterator()
    val results = mutableSetOf<Int>()
    val sums = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    while (results.size < n) {
        val p = ps.next()
        val key = cubeWeight(p)
        val lst = sums.getOrDefault(key, mutableListOf<Pair<Int, Int>>())
        lst.add(p)
        sums.put(key, lst)
        if (lst.size > 1) {
            results.add(key)
        }
    }
    return results.toList().sorted()
}