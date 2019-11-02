package com.example.script_em

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MotionEventCompat
import android.util.Log
import android.view.MotionEvent

private const val DEBUG_TAG = "Velocity"


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action: Int = MotionEventCompat.getActionMasked(event)

        return when (action) {

            (MotionEvent.ACTION_MOVE) -> {

                val vertoffset: Float = event.y
                val horoffset: Float = event.x
                Log.d(DEBUG_TAG, "The Vert"  + vertoffset + "The Horz" +horoffset)
                //Log.d(DEBUG_TAG, "Action was MOVE")
                true
            }

            MotionEvent.ACTION_CANCEL -> {
                Log.d(DEBUG_TAG, "Action was CANCEL")
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d(DEBUG_TAG, "Movement occurred outside bounds of current screen element")
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}
