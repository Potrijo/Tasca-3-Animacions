package com.example.tasca1_imatgeiso

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Matrix
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var monigote: ImageView
    lateinit var fadeIn: Button
    lateinit var fadeOut: Button
    lateinit var zoomIn: Button
    lateinit var zoomOut: Button
    lateinit var leftRight: Button
    lateinit var topBottom: Button
    lateinit var bounce: Button
    lateinit var flash: Button
    lateinit var rotate: Button
    lateinit var allTogether: Button
    lateinit var barraDuration: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        var animation1: Animation = AnimationUtils.loadAnimation(this, R.anim.flash);


        monigote = findViewById(R.id.imageView2)
        fadeIn = findViewById<Button>(R.id.button1)
        fadeOut = findViewById<Button>(R.id.button2)
        zoomIn = findViewById<Button>(R.id.button3)
        zoomOut = findViewById<Button>(R.id.button4)
        leftRight = findViewById<Button>(R.id.button9)
        topBottom = findViewById<Button>(R.id.button6)
        bounce = findViewById<Button>(R.id.button7)
        flash = findViewById<Button>(R.id.button8)
        rotate = findViewById<Button>(R.id.button)
        allTogether = findViewById<Button>(R.id.button10)
        barraDuration = findViewById<SeekBar>(R.id.seekBar2)


        fadeIn.setOnClickListener {
            mostra()
        }

        fadeOut.setOnClickListener {
            amaga()
        }

        zoomIn.setOnClickListener {
            apropa()
        }

        zoomOut.setOnClickListener {
            allunya()
        }

        leftRight.setOnClickListener {
            dretaEsquerra()
        }

        topBottom.setOnClickListener {
            amuntBaix()
        }
        bounce.setOnClickListener {
            monigote.startAnimation(animation)
            //animation.duration = (barraDuration.progress * 0.1).toLong()
        }
        flash.setOnClickListener {
            monigote.startAnimation(animation1)
            //animation.duration = (barraDuration.progress * 0.1).toLong()
        }
        rotate.setOnClickListener {
            rota()
        }
        allTogether.setOnClickListener {
            junts()
        }
    }

    private fun mostra() {
        val animator = ObjectAnimator.ofFloat(monigote, View.ALPHA, Float.MAX_VALUE)
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.start()
    }

    private fun amaga() {
        // Fade the view out to completely transparent and then back to completely opaque

        val animator = ObjectAnimator.ofFloat(monigote, View.ALPHA, 0f)
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.start()
    }

    private fun apropa() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(monigote, scaleX, scaleY)
        animator.repeatCount = 1
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE

        animator.start()
    }

    private fun allunya() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f-1)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f-1)
        val animator = ObjectAnimator.ofPropertyValuesHolder(monigote, scaleX, scaleY)
        animator.repeatCount = 1
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE

        animator.start()
    }

    private fun dretaEsquerra() {
        val animator = ObjectAnimator.ofFloat(monigote, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun amuntBaix() {
        val animator = ObjectAnimator.ofFloat(monigote, View.TRANSLATION_Y, 200f)
        animator.repeatCount = 1
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun bota() {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(monigote, View.TRANSLATION_X, 200f)
        animator.startDelay = 500
        //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000
        animator.start()


    }
    private fun destello() {
    }
    private fun rota() {
        val matrix = Matrix()
        val animator = ObjectAnimator.ofFloat(monigote, View.ROTATION, -360f, 0f)
       //animator.duration = (barraDuration.progress * 0.1).toLong()
        animator.duration = 1000

        animator.start()
    }
    private fun junts() {
        rota()
        dretaEsquerra()
    }

}