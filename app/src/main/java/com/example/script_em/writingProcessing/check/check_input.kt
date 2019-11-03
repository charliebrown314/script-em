package com.example.script_em.writingProcessing.check

import com.example.script_em.structures.Full_Char
import com.example.script_em.structures.Point

class check_input(val firstInput: Sequence<Point>, val char: Full_Char) {

    var proportion: Double = 1.0

    fun getProportion(): Boolean {
        /* Run only on the first Input Sequence;
         * This will determine the proportion to follow for future Layers;
          * Needs to:
          * - Check slope is within reasonable range
          * - If slope is reasonable, Set proportion equal to percent diff in general lengths*/
        return false
    }

    fun checkLayer(inputSeq: Sequence<Point>, initialSeq: Sequence<Point>): Boolean {
        /* Run on all but first Input Sequence;
         * This will determine if a layer is correct when it is written;
          * Needs to:
          * - Check slope is reasonable
          * - If slope is reasonable, check proportion is reasonable*/
        

        return false
    }

}