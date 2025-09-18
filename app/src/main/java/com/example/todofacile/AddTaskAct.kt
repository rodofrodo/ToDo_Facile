package com.example.todofacile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddTaskAct : AppCompatActivity() {
    private lateinit var taskName: EditText
    private lateinit var tagNameFirst: EditText
    private lateinit var tagColorFirst: EditText
    private lateinit var tagNameSecond: EditText
    private lateinit var tagColorSecond: EditText
    private lateinit var addTaskBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        taskName = findViewById(R.id.taskName)
        tagNameFirst = findViewById(R.id.tagName_first)
        tagColorFirst = findViewById(R.id.tagColor_first)
        tagNameSecond = findViewById(R.id.tagName_second)
        tagColorSecond = findViewById(R.id.tagColor_second)
        addTaskBtn = findViewById(R.id.addTaskBtn)
        // ---
        addTaskBtn.setOnClickListener { addTask() }
    }

    private fun addTask() {
        Constants.addInstance(taskName.text.toString(),
            tagNameFirst.text.toString(),
            tagColorFirst.text.toString().toColorInt(),
            tagNameSecond.text.toString(),
            tagColorSecond.text.toString().toColorInt(),
            Constants.BLOCKING_WORD, "#ffffff".toColorInt())
        finish()
    }
}