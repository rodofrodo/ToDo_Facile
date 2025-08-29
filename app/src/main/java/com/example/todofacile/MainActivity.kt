package com.example.todofacile

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {
    // global control init
    private lateinit var dateLbl: TextView
    private lateinit var linearLayout: LinearLayout

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
        showCurrentDate()
        initFun()
    }

    private fun showCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        val customFormatted = current.format(formatter)
        dateLbl.text = customFormatted
    }

    private fun initFun() {
        val itemLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
            setBackgroundResource(R.drawable.bg_item)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 24)
            layoutParams = params
        }
        val title1 = TextView(this).apply {
            setPadding(15, 5, 15, 10)
            text = "Do some housework"
            textSize = 16f
            setTextColor("#ffffff".toColorInt())
        }
        val title2 = TextView(this).apply {
            setPadding(5, 0, 5, 0)
            text = "important"
            textSize = 12f
            setTextColor("#ffffff".toColorInt())
            setTypeface(null, Typeface.BOLD)
        }
        val flag = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(10, 10, 10, 10)
            setBackgroundResource(R.drawable.bg_item)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 0)
            layoutParams = params
        }
        val bg = flag.background.mutate()
        bg.setTint("#FF5722".toColorInt())
        flag.addView(title2)
        itemLayout.addView(title1)
        itemLayout.addView(flag)
        itemLayout.setOnClickListener {
            title1.paintFlags = title1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            title1.setTextColor("#999999".toColorInt())
        }
        linearLayout.addView(itemLayout)
    }
}