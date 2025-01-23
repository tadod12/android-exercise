package com.example.class2111

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.button_second).setOnClickListener {
            finish()
        }

        val textContent = findViewById<TextView>(R.id.intent_content)
        val value1 = intent.getIntExtra("param1", 0)
        val value2 = intent.getDoubleExtra("param2", 0.0)
        val value3 = intent.getStringExtra("param3")
        textContent.text = "$value1\n$value2\n$value3"
    }
}