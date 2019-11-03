package com.example.script_em.writingProcessing.create

import com.example.script_em.structures.Point

object makeChar {

    var char: List<Point> = listOf()

    fun addToChar(x: Double, y: Double, size: Double) {
        val pt = Point(x,y)
        pt.size = size
        char += pt

    }

}