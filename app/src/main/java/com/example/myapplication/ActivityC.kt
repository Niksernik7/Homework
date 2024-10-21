package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val buttonOpenActivityA: Button = findViewById(R.id.button_open_activity_a)
        Log.d("сообщение", "активити С Task ID: $taskId")

        buttonOpenActivityA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }
    }
}