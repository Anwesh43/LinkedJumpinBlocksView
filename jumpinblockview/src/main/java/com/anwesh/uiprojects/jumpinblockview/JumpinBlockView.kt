package com.anwesh.uiprojects.jumpinblockview

/**
 * Created by anweshmishra on 07/10/19.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.graphics.RectF
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity

val nodes : Int = 5
val scGap : Float = 0.01f
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawJumpinBlock(size : Float, h : Float, scale : Float, paint : Paint) {
    val deg : Double = (Math.PI / 180f) * scale
    val y : Float = h * Math.sin(deg).toFloat()
    save()
    translate(0f, y)
    drawRect(RectF(-size, -size, size, size), paint)
    restore()
}

fun Canvas.drawJBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    save()
    translate(gap * (i + 1), h - size)
    drawJumpinBlock(size, h / 2, scale, paint)
    restore()
}
