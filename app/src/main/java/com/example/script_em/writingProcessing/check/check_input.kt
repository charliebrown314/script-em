package com.example.script_em.writingProcessing.check

import com.example.script_em.structures.Point

class check_input(val firstInput: Sequence<Point>, char: ) {



    fun checkLayer(inputSeq: Sequence<Point>, initialSeq: Sequence<Point>): Boolean {
        /* Run on all but first Input Sequence;
         * This will determine if a layer is correct when it is written;
          * Needs to:
          * - Check slope is reasonable
          * - If slope is reasonable, check proportion is reasonable*/


        return false
    }

    fun isInRange(intialSeq: List<Point>, input: Point): Boolean {
        var valid: Boolean = false
        for (point in intialSeq) {
            //  point falls within the accepted range
            if ((input.x > point.x-10 && input.x < point.x + 10) && (input.y > point.y-10 && input.y < point.y+10)) {
                valid = true
                break
            }
        }
        return valid
    }

    fun charCorrectness(initialList: List<Point>, scaledList: List<Point>): Double {
        //  percentage of how accurate the stroke is according to the standard solution
        var length: Int = 0
        var passed: Int = 0
        var listBuffer: List<Point> = scaledList
        for (point in scaledList) {
            if (isInRange(initialList, point)) {

                passed++
            }
            length++
        }
        return (passed.toDouble()/length.toDouble())*100
    }

}