package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val buttonOpenActivityC: Button = findViewById(R.id.button_open_activity_c)
        val taskId = getTaskId()
        Log.d("сообщение", " активити Б Task ID: $taskId")

        buttonOpenActivityC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
        }
    }
}