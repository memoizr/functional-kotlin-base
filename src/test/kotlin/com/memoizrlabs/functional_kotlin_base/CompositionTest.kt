package com.memoizrlabs.functional_kotlin_base

import org.junit.Assert.assertEquals
import org.junit.Test

class CompositionTest {
    @Test
    fun composesTwoFunctionsLeftToRight() {
        val addTenThenMultiplyByTen = { x: Int -> x + 10 } andThen { it * 10 }

        assertEquals(addTenThenMultiplyByTen(5), (5 + 10) * 10)
        assertEquals(addTenThenMultiplyByTen(-5), (-5 + 10) * 10)
    }
    @Test
    fun composesTwoFunctionsRightToLeft() {
        val multiplyByTenThenAddTen = { x: Int -> x + 10 } compose { x: Int -> x * 10 } compose { x: Int -> x + 3 }

        assertEquals(multiplyByTenThenAddTen(5), (5 * 10) + 10)
        assertEquals(multiplyByTenThenAddTen(-5), (-5 * 10) + 10)
    }

    @Test
    fun foo() {
        val multiply: (Int, Int) -> Int = { a: Int, b: Int -> a * b }
        val multiplyByFive: (Int) -> Int = multiply(5)

        val message: Int = multiplyByFive(3)
        val x: Int = multiply(5)(3)
        println(message)
    }
}
