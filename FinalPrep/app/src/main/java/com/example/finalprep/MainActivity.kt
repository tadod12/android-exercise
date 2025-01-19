package com.example.finalprep

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtMsg: TextView = findViewById(R.id.hello)

        val items: Array<String> = arrayOf(
            "Data-0", "Data-1", "Data-2", "Data-3", "Data-4", "Data-5"
        )

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, items
        )

        val listView: ListView = findViewById(R.id.list_view)

        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, i, _ ->
            txtMsg.text = "Position: $i\nData: ${items[i]}"
        }
        
        listView.setOnItemClickListener { parent, view, position, id ->  }
    }
}