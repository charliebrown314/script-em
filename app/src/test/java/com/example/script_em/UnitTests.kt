package com.example.script_em

import com.example.script_em.structures.*
import com.example.script_em.structures.Char
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
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
            assertEquals(testSet[pt].x,
                com.example.script_em.writingProcessing.create.makeChar.char.toList()[pt].x, .25)
            assertEquals(testSet[pt].y,
                com.example.script_em.writingProcessing.create.makeChar.char.toList()[pt].y, .25)
        }
    }
    @Test
    fun testChecker(){
        val charA = Char(listOf(Point(1.0,1.0),Point(1.0,2.0),
            Point(1.0,3.0), Point(2.0,3.0), Point(3.0,3.0),
            Point(3.0,2.0),Point(3.0,1.0),
            Point(3.0,4.0), Point(3.0,5.0)))
        val charB = Char(listOf(Point(1.0,1.0),Point(1.0,2.0),
            Point(1.0,3.0), Point(2.0,3.0), Point(3.0,3.0),
            Point(3.0,2.0),Point(3.0,1.0),
            Point(3.0,4.0), Point(3.0,5.0)))
        assertEquals(100.0, com.example.script_em.writingProcessing.check.check_input.charCorrectness(charA,charB), 1.0)
    }
}
