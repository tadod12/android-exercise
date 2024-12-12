package com.example.midtermprep

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.test)

        val count = 123

//        text.text = "" + count
//        text.text = "$count"
        text.setText(count)
//        text.text = count.toString()
//        text.fon
    }
}
