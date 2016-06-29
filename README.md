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
fun curriesValueFunctions() {
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
fun curriesValueFunctionsOneByOne() {
    assertEquals(add(1)(1)(1)(1)(1), 5)
}
```
This also works with methods (as long as they're not generic), but you have to first invoke it with `.invoke(instance)`

```
class CurryingTest {
    @Test
    fun curriesFunctions() {
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
###Composition
You can apply one function, and then pass the result as the input to another function (left to right):
```
@Test
fun composesTwoFunctionsLeftToRight() {
    val addTenThenMultiplyByTen = { x: Int -> x + 10 } andThen { it * 10 }

    assertEquals(addTenThenMultiplyByTen(5), (5 + 10) * 10)
    assertEquals(addTenThenMultiplyByTen(-5), (-5 + 10) * 10)
}
```

or you can do the same, but right to left:
```
@Test
fun composesTwoFunctionsRightToLeft() {
    val multiplyByTenThenAddTen = { x: Int -> x + 10 } compose { x: Int -> x * 10 } compose { x: Int -> x + 3 }

    assertEquals(multiplyByTenThenAddTen(5), (5 * 10) + 10)
    assertEquals(multiplyByTenThenAddTen(-5), (-5 * 10) + 10)
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
