package com.example.script_em.writingProcessing.create

import com.beust.klaxon.json
import com.example.script_em.structures.Point

object makeChar {

    var char: MutableSet<Point> = mutableSetOf()

    fun addToChar(x: Double, y: Double) {
        char.add(Point(x,y))

    }


    fun finishChar(name: String, size: Double) {
        khttp.post(
            url = "pythonserverurl/saveChar",
            json = mapOf("name" to name,
                "points" to json { array(char) }.toJsonString(), "size" to size.toString())
        )
    }
}