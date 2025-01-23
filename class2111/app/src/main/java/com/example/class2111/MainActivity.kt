package com.example.class2111

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_main).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("param1", 1234)
            intent.putExtra("param2", 3.14)
            intent.putExtra("param3", "hello")
            startActivity(intent)
        }

        val textResult = findViewById<TextView>(R.id.result)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {
                    it: ActivityResult ->
                    if (it.resultCode == RESULT_OK) {
                        val name = it.data?.getStringExtra("name")
                        val id = it.data?.getStringExtra("id")

                        textResult.text = "$name\n$id\n"
                    } else {
                        textResult.text = "CANCELED"
                    }
            }

        findViewById<Button>(R.id.button_add).setOnClickListener ({
            val intent = Intent(this, AddStudentActivity::class.java)
            launcher.launch(intent) // wait for result
        })
    }
}