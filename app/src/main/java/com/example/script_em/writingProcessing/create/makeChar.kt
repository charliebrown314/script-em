package com.example.script_em.writingProcessing.create

import com.beust.klaxon.json
import com.example.script_em.structures.Char
import com.example.script_em.structures.Point
import com.example.script_em.structures.Storage

object makeChar {

    var char: MutableSet<Point> = mutableSetOf()

    fun addToChar(x: Double, y: Double) {
        char.add(Point(x,y))
    }


    fun finalizeChar(size: Double): Char{
        val Char = Char(char.toList())
        Char.pointSize = size
        return Char
    }

    fun clear(){
        char = mutableSetOf()
    }
    fun finishChar(name: String, size: Double, storage: Storage) {
        val toAdd = finalizeChar(size)
        toAdd.name = name
        storage.charList += toAdd
//        khttp.post(
//            url = "https:///saveChar",
//            json = mapOf("name" to name,
//                "points" to json { array(char) }.toJsonString(), "size" to size.toString())
//        )
    }
}