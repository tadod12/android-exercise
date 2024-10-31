package com.example.simplelist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input: EditText = findViewById(R.id.input)
        val odd: RadioButton = findViewById(R.id.odd)
        val even: RadioButton = findViewById(R.id.even)
        val square: RadioButton = findViewById(R.id.square)
        val show: Button = findViewById(R.id.show)
        val result: TextView = findViewById(R.id.result)
        val list: ListView = findViewById(R.id.list)

        show.setOnClickListener {
            val number = input.text.toString().toIntOrNull()

            if (number == null || number < 0) {
                errorInput(result)
            } else {
                if (even.isChecked) {
                    result.text = getString(R.string.result)
                    val items = mutableListOf<Int>()
                    for (i in 0..number step 2) {
                        items.add(i)
                    }
                    val adapter: ArrayAdapter<Int> = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        items
                    )
                    list.adapter = adapter
                } else if (odd.isChecked) {
                    result.text = getString(R.string.result)
                    val items = mutableListOf<Int>()
                    for (i in 1..number step 2) {
                        items.add(i)
                    }
                    val adapter: ArrayAdapter<Int> = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        items
                    )
                    list.adapter = adapter
                } else if (square.isChecked) {
                    result.text = getString(R.string.result)
                    val items = mutableListOf<Int>()
                    var i = 1
                    while (i * i <= number) {
                        items.add(i*i)
                        i += 1
                    }
                    val adapter: ArrayAdapter<Int> = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        items
                    )
                    list.adapter = adapter
                } else {
                    errorInput(result)
                }
            }
        }
    }

    private fun errorInput(view: TextView) {
        view.text = getString(R.string.invalid_input)
    }
}