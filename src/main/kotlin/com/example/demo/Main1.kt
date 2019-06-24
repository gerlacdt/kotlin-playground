package com.example.demo


import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random


fun main() = runBlocking<Unit> {

    for (i in 0..10) {
        launch {
            val value = nextInt(Random.nextLong(1000L))
            println("value[$i] =  $value")
        }
    }
}

suspend fun nextInt(delayVal: Long): Int {
    delay(delayVal)
    return Random.nextInt(100)
}
