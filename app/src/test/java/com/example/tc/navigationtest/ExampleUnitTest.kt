package com.example.tc.navigationtest

import org.junit.Test

import org.junit.Assert.*
import java.lang.StringBuilder

/**
 * Example local unit testjson, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testJson() {
        val collection = ArrayList<Int>()
        collection.add(1)
        collection.add(2)
        collection.add(555)
        collection.add(3)
        collection.add(14)
        collection.add(15)
//        println(collection)
//        println(toJSON(collection))
        println(joinOptions(toJSON(collection)))
    }

    fun joinOptions(options: Collection<String>) = options.joinToString(", ", "[", "]")

    fun toJSON(collection: Collection<Int>): Collection<String> {
        val collectionString = ArrayList<String>()
        val sb = StringBuilder()
        sb.append("[")
        collectionString.add("[")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            sb.append(element)
            collectionString.add("" + element)
            if (iterator.hasNext()) {
                sb.append(", ")
                collectionString.add(", ")
            }
        }
        sb.append("]")
        collectionString.add("]")
        return collectionString
    }

}
