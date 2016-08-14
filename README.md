[![Build Status](https://travis-ci.org/memoizr/functional-kotlin-base.svg?branch=master)](https://travis-ci.org/memoizr/functional-kotlin-base)
### Functional Kotlin
This is a small library that add support for currying and function composition in Kotlin. It is very important to be able to compose functions and curry them if one wants to adopt a more functional style.

###Currying
Say you have a function that takes several parameter:
```
val add = { a: Int, b: Int, c: Int, d: Int, e: Int -> a + b + c + d + e}
```
These parameters can now be applied one by one. The result of partial application is a partial function that takes a smaller number of parameters:
```
@Test
fun `Curries value functions`() {
    val tenPlusAdd = add(10)
    val twentyPlusAdd = tenPlusAdd(10)
    val thirtyPlusAdd = twentyPlusAdd(10)
    val fortyPlusAdd = thirtyPlusAdd(10)

    assertEquals(fortyPlusAdd(1), 41)
}
```

Or alternatively:
```
@Test
fun `Curries value functions one by one`() {
    assertEquals(add(1)(1)(1)(1)(1), 5)
}
```
This also works with methods (as long as they're not generic), but you have to first invoke it with `.invoke(instance)`

```
class CurryingTest {
    @Test
    fun `Curries functions`() {
        val add = CurryingTest::testAdd.invoke(this)
        val tenPlusAdd = add(10)
        val twentyPlusAdd = tenPlusAdd(10)
        val thirtyPlusAdd = twentyPlusAdd(10)
        val fortyPlusAdd = thirtyPlusAdd(10)
    
        assertEquals(fortyPlusAdd(1), 41)
    }

    fun testAdd(a: Int, b: Int, c: Int, d: Int, e: Int) = a + b + c + d + e
}
```

###Uncurrying
If you have a curried function you can uncurry it and call it as if it took however many parameters it needs:

```
    val addFiveNumbers = { a: Int -> { b: Int -> { c: Int -> { d: Float -> { e: Int ->
                        a + b + c + d + e
                    }}}}}

    @Test
    fun `Curries partial functions of mixed types`() {
        assertEquals(15.0f, addFiveNumbers(1, 2, 3, 4.0f, 5))
    }
```

###Composition
You can apply one function, and then pass the result as the input to another function (left to right):
```
@Test
fun `andThen composes two functions left to right`() {
    val addTenThenMultiplyByTen = { x: Int -> x + 10 } andThen { it * 10 }

    assertEquals(addTenThenMultiplyByTen(5), (5 + 10) * 10)
    assertEquals(addTenThenMultiplyByTen(-5), (-5 + 10) * 10)
}
```

or you can do the same, but right to left:
```
@Test
fun `compose composes two functions right to left`() {
    val multiplyByTenThenAddTen = { x: Int -> x + 10 } compose { x: Int -> x * 10 } compose { x: Int -> x + 3 }

    assertEquals(multiplyByTenThenAddTen(5), (5 * 10) + 10)
    assertEquals(multiplyByTenThenAddTen(-5), (-5 * 10) + 10)
}
```

###Head and Tail
Another bit of functionality you'd expect from a functional language is decent syntax for getting the head and tail of a list (car and cdr for the schemers). You can do this by using the extension properties "head" and "tail".
```
@Test
fun `head returns the first element in a list`() {
    assertEquals(listOf(1,2,3,4,5).head, 1)
}

@Test
fun `tail returns the last element in a list`() {
    assertEquals(listOf(1,2,3,4,5).tail, listOf(2,3,4,5))
}
```
That's it!

### License
Copyright 2016 memoizr

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
