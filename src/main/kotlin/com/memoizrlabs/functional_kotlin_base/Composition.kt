package com.memoizrlabs.functional_kotlin_base

infix fun <A, B, C, T : (A) -> B> T.andThen(other: (B) -> C): (A) -> C = { a: A -> other(invoke(a)) }
infix fun <A, B, C, T : (B) -> C> T.compose(other: (A) -> B): (A) -> C = { a: A -> invoke(other(a)) }
