package com.example.class2111

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)

        val editName = findViewById<EditText>(R.id.name)
        val editId = findViewById<EditText>(R.id.id)

        findViewById<Button>(R.id.ok).setOnClickListener {
            val name = editName.text.toString()
            val id = editId.text.toString()
            // return
            intent.putExtra("name", name)
            intent.putExtra("id", id)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        findViewById<Button>(R.id.cancel).setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}