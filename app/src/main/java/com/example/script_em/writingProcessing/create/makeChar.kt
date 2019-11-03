package com.example.script_em.writingProcessing.create

import com.example.script_em.structures.Char_Layer
import com.example.script_em.structures.Full_Char
import com.example.script_em.structures.Point

object makeChar {

    var currSeq: Sequence<Point> = sequenceOf()
    var charInCreation: Full_Char = Full_Char()

    fun addToLayer(x: Double, y: Double) {
        currSeq += Point(x,y)
    }

    fun saveLayer(){
        charInCreation.layers += Char_Layer(currSeq)
        currSeq = sequenceOf()
    }

    fun completeChar() {
        charInCreation.generateOptimization()
    }
}