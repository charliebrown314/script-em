package com.example.script_em

import android.content.Intent
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
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.script_em.structures.Char
import com.example.script_em.structures.Storage
import kotlinx.android.synthetic.main.activity_main.*

private const val DEBUG_TAG = "Velocity"


class MainActivity : AppCompatActivity() {
    var prevx: Float = 0F
    var prevy: Float =0F
    var bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
    var canvas = Canvas(bitmap)
    //var Swap:Button = newsymbol

    var storage: Storage = Storage()
    var size: Double = 8.0
    var selectedChar: Char = Char(listOf())


    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                canvas.drawColor(Color.LTGRAY)
                //imageV.background = BitmapDrawable(getResources(), bitmap)

            }
            fun Clearing(view: View) {
                val button: Button = findViewById(R.id.clear)
                button.setOnClickListener {
                    bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
                    canvas = Canvas(bitmap)
                    canvas.drawColor(Color.LTGRAY)
                    imageV.background = BitmapDrawable(getResources(), bitmap)
                    prevx = 0F
                    prevy = 0F
                    com.example.script_em.writingProcessing.create.makeChar.clear()
                }
            }
            fun newsymbol(view: View){
                val button: Button = findViewById(R.id.Next)
                button.setOnClickListener {
                    //server pick one at random
                    if(storage.charList.size - 1 > storage.selectedChar){
                     storage.selectedChar += 1
                        selectedChar = storage.charList[storage.selectedChar]
                        CurrentSym("Current char: " + selectedChar.name)
                    }
                    else {
                        if (storage.selectedChar != 0) {
                            storage.selectedChar = 0
                            selectedChar = storage.charList[storage.selectedChar]
                            CurrentSym("Current char: " + selectedChar.name)
                        }
                        else{
                            CurrentSym("Current char: " + selectedChar.name)
                        }
                    }
        }
    }
    fun NewInput(view: View){
        com.example.script_em.writingProcessing.create.makeChar.finishChar(add(), size, storage)
        selectedChar = storage.charList[storage.selectedChar]
        bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
        canvas = Canvas(bitmap)
        canvas.drawColor(Color.LTGRAY)
        imageV.background = BitmapDrawable(getResources(), bitmap)
        prevx = 0F
        prevy = 0F
    }



    fun CurrentSym(Str: String){
        val textView = findViewById<TextView>(R.id.editText)
        textView.setText(Str)
        val textViewValue = textView.text
        bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
        canvas = Canvas(bitmap)
        canvas.drawColor(Color.LTGRAY)
        imageV.background = BitmapDrawable(getResources(), bitmap)
        prevx = 0F
        prevy = 0F

    }
    fun add(): String {
        val textView = findViewById<TextView>(R.id.editText2)
        val textViewValue = textView.text
        bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
        canvas = Canvas(bitmap)
        canvas.drawColor(Color.LTGRAY)
        imageV.background = BitmapDrawable(getResources(), bitmap)
        prevx = 0F
        prevy = 0F
        return textViewValue.toString()
    }

    fun SendForChecking(view: View) {
        val button: Button = findViewById(R.id.clear)
        button.setOnClickListener {
            bitmap = Bitmap.createBitmap(1080, 2260, Bitmap.Config.ARGB_4444)
            canvas = Canvas(bitmap)
            canvas.drawColor(Color.LTGRAY)
            imageV.background = BitmapDrawable(getResources(), bitmap)
            prevx = 0F
            prevy = 0F
            CurrentSym("% Correct: " + com.example.script_em.writingProcessing.check.check_input.charCorrectness(selectedChar,
                com.example.script_em.writingProcessing.create.makeChar.finalizeChar(size)).toInt().toString())
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action: Int = MotionEventCompat.getActionMasked(event)
        if(action == 0 || action == 1){
            canvas.drawCircle(event.x, event.y, 4.toFloat(), Paint(Color.parseColor("black")))
            imageV.background = BitmapDrawable(getResources(), bitmap)
            prevy = 0F
            prevx = 0F
        }
        return when (action) {

//work
            (MotionEvent.ACTION_MOVE) -> {

                val vertoffset: Float = event.y.toInt().toFloat()
                val horoffset: Float = event.x.toInt().toFloat()

                com.example.script_em.writingProcessing.create.makeChar.addToChar(horoffset.toDouble(),vertoffset.toDouble())
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
                canvas.drawCircle(horoffset, vertoffset, 1.toFloat(), Paint(Color.parseColor("black")))
                if(prevx != 0F && prevy != 0F) {
                    canvas.drawLine(prevx-7 , prevy-7, horoffset-7, vertoffset-7,paint)
                    canvas.drawLine(prevx-6, prevy-6, horoffset-6, vertoffset-6,paint)
                    canvas.drawLine(prevx-5, prevy-5, horoffset-5, vertoffset-5,paint)
                    canvas.drawLine(prevx-4, prevy-4, horoffset-4, vertoffset-4,paint)
                    canvas.drawLine(prevx-3, prevy-3, horoffset-3, vertoffset-3, paint)
                    canvas.drawLine(prevx-2, prevy-2, horoffset-2, vertoffset-2, paint)
                    canvas.drawLine(prevx-1, prevy-1, horoffset-1, vertoffset-1, paint)
                    canvas.drawLine(prevx, prevy, horoffset, vertoffset, paint)
                    canvas.drawLine(prevx+1, prevy+1, horoffset+1, vertoffset+1, paint)
                    canvas.drawLine(prevx+2, prevy+2, horoffset+2, vertoffset+2, paint)
                    canvas.drawLine(prevx+3, prevy+3, horoffset+3, vertoffset+3, paint)
                    canvas.drawLine(prevx+4, prevy+4, horoffset+4, vertoffset+4, paint)
                    canvas.drawLine(prevx+5, prevy+5, horoffset+5, vertoffset+5, paint)
                    canvas.drawLine(prevx+6, prevy+6, horoffset+6, vertoffset+6, paint)
                    canvas.drawLine(prevx+7, prevy+7, horoffset+7, vertoffset+6, paint)


                }
                prevx = horoffset
                prevy = vertoffset
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
