package com.example.script_em.writingProcessing.check

import com.example.script_em.structures.Char
import com.example.script_em.structures.Point

object check_input {



    fun isInRange(correctList: MutableSet<Point>, input: Point): Pair<Boolean, Point> {
        for (point in correctList) {
            //  point falls within the accepted range
            if ((input.x > point.x-point.size && input.x < point.x + point.size)
                && (input.y > point.y-point.size && input.y < point.y+point.size)) {
                return Pair(true, point)
            }
        }
        return Pair(false, Point(0.0,0.0))
    }

    fun charCorrectness(correct: Char, input: Char): Double {
        //  percentage of how accurate the stroke is according to the standard solution
        var correctListChecklist = correct.points
        var length: Int = 0
        var passed: Int = 0
        for (point in input.points) {
            val inRange = isInRange(correct.points, point)
            if (inRange.first) {
                correctListChecklist.remove(inRange.second)
                passed++
            }
            length++
        }
        return (((passed.toDouble()/length.toDouble())*.4)
        + ((correctListChecklist.size.toDouble()/correct.points.size.toDouble())*.6))*100
    }

}