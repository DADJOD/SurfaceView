package com.example.surfaceview

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceHolder.Callback2
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var paperCanvas: Canvas
    private var height: Int = 0
    private var width: Int = 0
    private lateinit var paperBitmap: Bitmap
    private lateinit var surface: Surface
    private lateinit var holder: SurfaceHolder
    private lateinit var surfaceView: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surfaceView = findViewById(R.id.surfaceView)
        holder = surfaceView.holder
        holder.addCallback(callback)
    }

    private var callback: Callback2 = object : Callback2 {
        override fun surfaceRedrawNeeded(holder: SurfaceHolder) {}
        override fun surfaceCreated(holder: SurfaceHolder) {}
        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            startPaint(width, height)
        }
        override fun surfaceDestroyed(holder: SurfaceHolder) {}
    }

    fun startPaint(width: Int, height: Int) {
        this.width = width
        this.height = height
        surface = holder.surface

        paperBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        paperCanvas = Canvas(paperBitmap)

        drawDot((width/2).toFloat(), (height/2).toFloat())
    }

    private val paintColor = 0xffff0000
    private val drawPaint: Paint = Paint()

    private fun init() {
        drawPaint.color = paintColor.toInt()
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
        drawPaint.strokeWidth = 20F
    }

    private fun drawDot(x: Float, y: Float) {
        init()
        paperCanvas.drawPoint(x, y, drawPaint)
        drawPaperBitmap()
    }

    fun drawPaperBitmap() {
        val canvas = surface.lockCanvas(null)
        canvas.drawBitmap(paperBitmap, 0F, 0F, null)
        surface.unlockCanvasAndPost(canvas)
    }
}