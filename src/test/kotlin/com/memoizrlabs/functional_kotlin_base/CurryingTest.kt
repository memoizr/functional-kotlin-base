package com.memoizrlabs.functional_kotlin_base

import org.junit.Assert.assertEquals
import org.junit.Test

class CurryingTest {
    val add = { a: Int, b: Int, c: Int, d: Int, e: Int -> a + b + c + d + e}

    @Test
    fun `Curries value functions`() {
        val tenPlusAdd = add(10)
        val twentyPlusAdd = tenPlusAdd(10)
        val thirtyPlusAdd = twentyPlusAdd(10)
        val fortyPlusAdd = thirtyPlusAdd(10)

        assertEquals(fortyPlusAdd(1), 41)
    }

    @Test
    fun `Curries value functions one by one`() {
        assertEquals(add(1)(1)(1)(1)(1), 5)
    }

    @Test
    fun `Curries methods`() {
        val add = CurryingTest::testAdd.invoke(this)
        val tenPlusAdd = add(10)
        val twentyPlusAdd = tenPlusAdd(10)
        val thirtyPlusAdd = twentyPlusAdd(10)
        val fortyPlusAdd = thirtyPlusAdd(10)

        assertEquals(fortyPlusAdd(1), 41)
    }

    fun testAdd(a: Int, b: Int, c: Int, d: Int, e: Int) = a + b + c + d + e
}
