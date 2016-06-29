package com.memoizrlabs.functional_kotlin_base

infix operator fun <A, B, R, FUN : (A, B) -> R> FUN.invoke(partial: A) = { other: B -> invoke(partial, other) }
infix operator fun <A, B, C, R, FUN : (A, B, C) -> R> FUN.invoke(partial: A) = { b: B, c: C -> invoke(partial, b, c) }
infix operator fun <A, B, C, D, R, FUN : (A, B, C, D) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D -> invoke(partial, b, c, d) }
infix operator fun <A, B, C, D, E, R, FUN : (A, B, C, D, E) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D, e: E -> invoke(partial, b, c, d, e) }
infix operator fun <A, B, C, D, E, F, R, FUN : (A, B, C, D, E, F) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D, e: E, f: F -> invoke(partial, b, c, d, e, f) }
