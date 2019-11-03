package com.example.script_em.structures

class Full_Char() {
    var layers: Sequence<Char_Layer> = sequenceOf()
    var optimizedLayers: Sequence<Char_Layer> = sequenceOf()

    fun generateOptimization() {
        /* Set optimizedLayers = Layers comprised of only significant points;
         * i.e) Sharp Changes / curves
          * Need to:
          * - Check for large slope changes (relative to size of Layer)
          * - Minimize each Layer to these significant points of change*/
    }
}