package com.memoizrlabs.functional_kotlin_base

val <T> List<T>.head: T get() = this.first()
val <T> List<T>.tail: List<T> get() = this.subList(1, size)

