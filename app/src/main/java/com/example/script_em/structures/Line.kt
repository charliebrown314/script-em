package com.example.script_em.structures

import kotlin.math.pow
import kotlin.math.sqrt


class Line(var start: Point, var end: Point ) {

    val length: Double = computeLength()
    val slope: Double = (end.y - start.y) / (end.x - start.x)

    fun computeLength(): Double {
        val a: Double = start.x - end.x
        val b: Double = start.y - end.y
        return sqrt(a.pow(2) + b.pow(2))
    }

}