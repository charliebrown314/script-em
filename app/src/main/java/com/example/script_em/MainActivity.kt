package com.example.script_em

import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MotionEventCompat
import android.util.Log
import android.view.MotionEvent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.util.DisplayMetrics
import android.view.MotionEvent.INVALID_POINTER_ID
import kotlinx.android.synthetic.main.activity_main.*

private const val DEBUG_TAG = "Velocity"


class MainActivity : AppCompatActivity() {
    //var points: Array[Array[Int]] =
    val bitmap = Bitmap.createBitmap(1060, 1080, Bitmap.Config.ARGB_4444)
    val canvas = Canvas(bitmap)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        canvas.drawColor(Color.LTGRAY)
        imageV.background = BitmapDrawable(getResources(), bitmap)


    }

    private var mActivePointerId = INVALID_POINTER_ID

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action: Int = MotionEventCompat.getActionMasked(event)


        return when (action) {

            (MotionEvent.ACTION_MOVE) -> {

                val vertoffset: Float = event.y.toInt().toFloat()
                val horoffset: Float = event.x.toInt().toFloat()


                // canvas background color

                var paint = Paint()
                paint.setColor(Color.parseColor("black"))
                paint.setAntiAlias(false)
                paint.setDither(true)

                // get device dimensions
                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                // circle center

                // draw circle
                canvas.drawCircle(horoffset, vertoffset, 10.toFloat(), paint)
                imageV.background = BitmapDrawable(getResources(), bitmap)
                Log.d(DEBUG_TAG, "The Vert"  + vertoffset + "The Horz" +horoffset)

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
