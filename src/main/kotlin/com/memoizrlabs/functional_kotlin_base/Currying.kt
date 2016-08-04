package com.memoizrlabs.functional_kotlin_base

operator fun <A, B, R, FUN : (A, B) -> R> FUN.invoke(partial: A) = { other: B -> invoke(partial, other) }
operator fun <A, B, C, R, FUN : (A, B, C) -> R> FUN.invoke(partial: A) = { b: B, c: C -> invoke(partial, b, c) }
operator fun <A, B, C, D, R, FUN : (A, B, C, D) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D -> invoke(partial, b, c, d) }
operator fun <A, B, C, D, E, R, FUN : (A, B, C, D, E) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D, e: E -> invoke(partial, b, c, d, e) }
operator fun <A, B, C, D, E, F, R, FUN : (A, B, C, D, E, F) -> R> FUN.invoke(partial: A) = { b: B, c: C, d: D, e: E, f: F -> invoke(partial, b, c, d, e, f) }

operator fun <A, B, C, T : (A) -> (B) -> C> T.invoke(a: A, b: B) = this(a)(b)
operator fun <A, B, C, D, T : (A) -> (B) -> (C) -> D> T.invoke(a: A, b: B, c: C) = this(a)(b)(c)
operator fun <A, B, C, D, E, T : (A) -> (B) -> (C) -> (D) -> E> T.invoke(a: A, b: B, c: C, d: D) = this(a)(b)(c)(d)
operator fun <A, B, C, D, E, F, T : (A) -> (B) -> (C) -> (D) -> (E) -> F> T.invoke(a: A, b: B, c: C, d: D, e: E) = this(a)(b)(c)(d)(e)
operator fun <A, B, C, D, E, F, G, T : (A) -> (B) -> (C) -> (D) -> (E) -> (F) -> G> T.invoke(a: A, b: B, c: C, d: D, e: E, f: F) = this(a)(b)(c)(d)(e)(f)
