package com.memoizrlabs.functional_kotlin_base

import org.junit.Assert
import org.junit.Test

class ListTest {
    @Test
    fun returnsHeadOfList() {
        Assert.assertEquals(listOf(1,2,3,4,5).head, 1)
    }

    @Test
    fun returnsTailOfList() {
        Assert.assertEquals(listOf(1,2,3,4,5).tail, listOf(2,3,4,5))
    }
}