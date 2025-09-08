package com.example.todofacile

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.size
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    // global control init
    private lateinit var dateLbl: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var taskCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // init
        dateLbl = findViewById(R.id.dateLbl)
        linearLayout = findViewById(R.id.linearLayout)
        taskCount = findViewById(R.id.taskCountText)
        // ---
        linearLayout.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
            taskCount.text = linearLayout.childCount.toString()
        }
        showCurrentDate()
        for (i in 0..10) {
            newMethod("Do some housework", "important", "#FF3333".toColorInt(),
                "for fun", "#FF3385".toColorInt(), Constants.BLOCKING_WORD, "#3DB766".toColorInt())
            newMethod("Write an essay", "school task", "#3DB766".toColorInt(),
                "crucial", "#FFC012".toColorInt(), "for now", "#6033FF".toColorInt())
        }
    }

    private fun showCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
        val customFormatted = current.format(formatter)
        dateLbl.text = customFormatted
    }

    private fun newMethod(titleText: String, a1: String, c1: Int, a2: String, c2: Int, a3: String, c3: Int) {
        // black
        val itemLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(24, 24, 24, 24)
            setBackgroundResource(R.drawable.bg_item)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 24)
            layoutParams = params
        }
        // blue
        val leftLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(5, 5, 5, 5)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 0)
            layoutParams = params
        }
        val circle = TextView(this).apply {
            setPadding(15, 5, 15, 10)
            text = "O"
            textSize = 14f
            setTextColor("#ffffff".toColorInt())
            gravity = Gravity.CENTER
        }
        leftLayout.addView(circle)
        val rightLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(5, 5, 5, 5)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 0)
            layoutParams = params
        }
        // main text
        val title = TextView(this).apply {
            setPadding(15, 5, 15, 10)
            text = titleText
            textSize = 18f
            setTextColor("#ffffff".toColorInt())
        }
        // purple
        val attributeLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(5, 5, 5, 5)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 0)
            layoutParams = params
        }
        // attributes
        // 1
        if (a1 != Constants.BLOCKING_WORD) {
            val att1 = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(25, 10, 25, 10)
                setBackgroundResource(R.drawable.btn_item)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 15, 0)
                layoutParams = params
            }
            val txt1 = TextView(this).apply {
                text = a1
                textSize = 14f
                setTextColor(c1)
                setTypeface(null, Typeface.BOLD)
            }
            val att1bg = att1.background.mutate()
            att1bg.setTint(ColorUtils.setAlphaComponent(c1, (0.1f * 255).toInt()))
            att1.addView(txt1)
            attributeLayout.addView(att1)
        }
        // 2
        if (a2 != Constants.BLOCKING_WORD) {
            val att2 = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(25, 10, 25, 10)
                setBackgroundResource(R.drawable.btn_item)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 15, 0)
                layoutParams = params
            }
            val txt2 = TextView(this).apply {
                text = a2
                textSize = 14f
                setTextColor(c2)
                setTypeface(null, Typeface.BOLD)
            }
            val att2bg = att2.background.mutate()
            att2bg.setTint(ColorUtils.setAlphaComponent(c2, (0.1f * 255).toInt()))
            att2.addView(txt2)
            attributeLayout.addView(att2)
        }
        // 3
        if (a3 != Constants.BLOCKING_WORD) {
            val att3 = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(25, 10, 25, 10)
                setBackgroundResource(R.drawable.btn_item)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 15, 0)
                layoutParams = params
            }
            val txt3 = TextView(this).apply {
                text = a3
                textSize = 14f
                setTextColor(c3)
                setTypeface(null, Typeface.BOLD)
            }
            val att3bg = att3.background.mutate()
            att3bg.setTint(ColorUtils.setAlphaComponent(c3, (0.1f * 255).toInt()))
            att3.addView(txt3)
            attributeLayout.addView(att3)
        }
        // right layout children
        rightLayout.addView(title)
        rightLayout.addView(attributeLayout)
        // ---
        itemLayout.setOnClickListener {
            linearLayout.removeView(itemLayout)
            //title.paintFlags = title.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            //title.setTextColor("#999999".toColorInt())
            //val mainBg = itemLayout.background.mutate()
            //mainBg.setTint("#191919".toColorInt())
        }
        itemLayout.addView(leftLayout)
        itemLayout.addView(rightLayout)
        linearLayout.addView(itemLayout)
    }
}