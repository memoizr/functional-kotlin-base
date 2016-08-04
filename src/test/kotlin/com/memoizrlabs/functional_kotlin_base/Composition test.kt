package com.memoizrlabs.functional_kotlin_base

import org.junit.Assert.assertEquals
import org.junit.Test

class `Composition test` {

    @Test
    fun `andThen composes two functions, from left to right`() {
        val addTenThenMultiplyByTen = { x: Int -> x + 10 } andThen { it * 10 }

        assertEquals(addTenThenMultiplyByTen(5), (5 + 10) * 10)
        assertEquals(addTenThenMultiplyByTen(-5), (-5 + 10) * 10)
    }

    @Test
    fun `compose composes two functions, right to left`() {
        val multiplyByTenThenAddTen = { x: Int -> x + 10 } compose { x: Int -> x * 10 }

        assertEquals(multiplyByTenThenAddTen(5), (5 * 10) + 10)
        assertEquals(multiplyByTenThenAddTen(-5), (-5 * 10) + 10)
    }
}
