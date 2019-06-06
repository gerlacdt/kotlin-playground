package com.example.demo

import org.junit.jupiter.api.Test

class TmpTests {

    @Test
    fun sum() {
        val result = 3 + 3
        assert(result == 6)
    }

    @Test
    fun subtract() {
        val result = 3 - 4
        assert(result == -1)
    }
}
