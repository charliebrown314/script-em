package com.example.script_em

import com.example.script_em.structures.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testCreate() {
        for(i in arrayOf(arrayOf(1.0,1.0),
            arrayOf(1.0,2.0),arrayOf(1.0,3.0),
            arrayOf(2.0,3.0),arrayOf(3.0,3.0),
            arrayOf(3.0,2.0),arrayOf(3.0,1.0),
            arrayOf(3.0,4.0),arrayOf(3.0,5.0))){
            com.example.script_em.writingProcessing.create.makeChar.addToChar(i[0],i[1])
        }

        val testSet = mutableSetOf(Point(1.0,1.0),Point(1.0,2.0),
            Point(1.0,3.0), Point(2.0,3.0), Point(3.0,3.0),
            Point(3.0,2.0),Point(3.0,1.0),
            Point(3.0,4.0), Point(3.0,5.0)).toList()
        for(pt in testSet.indices){
            assertEquals(testSet[pt], com.example.script_em.writingProcessing.create.makeChar.char.toList()[pt])
        }
    }
}
