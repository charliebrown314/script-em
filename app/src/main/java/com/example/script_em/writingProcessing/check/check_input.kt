package com.example.script_em.writingProcessing.check

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.example.script_em.structures.Char
import com.example.script_em.structures.Point
import khttp.get

class reqChar(val name: String, val list: List<Point>, val size: Double)

object check_input {


    fun requestChar(name: String): Char {
        val request = get(
            url = "",
            params = mapOf("name" to name)
        )
        val jsParsed = Klaxon().parse<reqChar>(request.text)
        val retChar = Char(jsParsed!!.list)
        retChar.pointSize = jsParsed.size
        return retChar
    }

    fun requestCharNames(): List<String> {
        val request = get(
            url= ""
        )
        return Klaxon().parseArray<String>(request.text)!!
    }

    fun isInRange(correctList: List<Point>, input: Point, size: Double): Pair<Boolean, Point> {
        for (point in correctList) {
            //  point falls within the accepted range
            if ((input.x > point.x-size && input.x < point.x + size)
                && (input.y > point.y-size && input.y < point.y+size)) {
                return Pair(true, point)
            }
        }
        return Pair(false, Point(0.0,0.0))
    }

    fun charCorrectness(correct: Char, input: Char): Double {
        //  percentage of how accurate the stroke is according to the standard solution
        var correctListChecklist = correct.points.toMutableSet()
        var length: Int = 0
        var passed: Int = 0
        for (point in input.points) {
            val inRange = isInRange(correct.points, point, correct.pointSize)
            if (inRange.first) {
                correctListChecklist.remove(inRange.second)
                passed++
            }
            length++
        }
        val percentIn = (passed.toDouble() / length.toDouble())
        val squaresFilled = 1 - (correctListChecklist.size.toDouble()/correct.points.size.toDouble())
        println(percentIn.toString() + ", " + squaresFilled)
        println(correct.points[0].toString())
        println(input.points[0])
        return ((percentIn * .4) + (squaresFilled * .6)) * 100
    }

}