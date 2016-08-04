package com.memoizrlabs.functional_kotlin_base

import org.junit.Assert.assertEquals
import org.junit.Test

class `Uncurrying test` {
    val addTwoNumbers = { a: Int -> { b: Int -> a + b } }
    val addThreeNumbers = { a: Int ->
        { b: Int ->
            { c: Int ->
                a + b + c
            }
        }
    }
    val addFourNumbers = { a: Int -> { b: Int -> { c: Int -> { d: Int -> a + b + c + d } } } }
    val addFiveNumbers = { a: Int ->
        { b: Int ->
            { c: Int ->
                { d: Float ->
                    { e: Int ->
                        a + b + c + d + e
                    }
                }
            }
        }
    }

    @Test
    fun `Curries partial functions`() {
        assertEquals(3, addTwoNumbers(1, 2))
        assertEquals(6, addThreeNumbers(1, 2, 3))
        assertEquals(10, addFourNumbers(1, 2, 3, 4))
    }

    @Test
    fun `Curries partial functions of mixed types`() {
        assertEquals(15.0f, addFiveNumbers(1, 2, 3, 4.0f, 5))
    }
}