package com.example.script_em.writingProcessing.create

import com.beust.klaxon.json
import com.example.script_em.structures.Point

object makeChar {

    var char: MutableSet<Point> = mutableSetOf()

    fun addToChar(x: Double, y: Double, size: Double) {
        val pt = Point(x,y)
        pt.size = size
        char.add(pt)

    }


    fun finishChar(name: String) {
        khttp.post(
            url = "pythonserverurl/saveChar",
            json = mapOf("name" to name, "points" to json { array(char) }.toJsonString())
        )
    }
}