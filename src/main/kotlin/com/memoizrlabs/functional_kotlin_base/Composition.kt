package com.memoizrlabs.functional_kotlin_base

infix fun <A, B, C, T : (A) -> B> T.andThen(other: (B) -> C) = { a: A -> other(invoke(a)) }
infix fun <A, B, C, T : (B) -> C> T.compose(other: (A) -> B) = { a: A -> invoke(other(a)) }
