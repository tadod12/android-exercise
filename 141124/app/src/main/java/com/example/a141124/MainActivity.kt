package com.example.a141124

import android.app.AlertDialog
//import android.app.DatePickerDialog
import android.app.Dialog
//import android.app.TimePickerDialog
//import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
//import android.widget.Toast
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
//            val items = resources.getStringArray(R.array.test_array)

//            AlertDialog.Builder(this)
//                .setTitle("Select an option")
//                .setItems(R.array.test_array // must be type array, can use toTypeArray
//                ) { _, position -> Log.v("TAG", "$position") }
//                .setPositiveButton("Cancel", null)
//                .show()

//            val selections = BooleanArray(items.size)
//
//            AlertDialog.Builder(this)
//                .setTitle("Select an option")
//                .setMultiChoiceItems(
//                    R.array.test_array,
//                    selections
//                ) { _, pos: Int, isSelected: Boolean ->
//                    Log.v("TAG", "$pos: $isSelected") }
////                .setSingleChoiceItems(
////                    R.array.test_array, 0
////                ) { _, position: Int -> Log.v("TAG", "$position") }
//                .setPositiveButton("OK") { _, _ -> }
//                .setNegativeButton("Cancel", null)
//                .show()

            val dialogView = LayoutInflater.from(this)
                .inflate(R.layout.layout_alert_dialog, null)

            val editInfo = dialogView.findViewById<EditText>(R.id.name)

            AlertDialog.Builder(this)
                .setTitle("Enter information")
                .setView(dialogView)
                .setPositiveButton("OK") { _, _ ->
                    val name = editInfo.text.toString()
                    Log.v("TAG", "name: $name")
                }
                .setNegativeButton("Cancel", null)
                .show()

//            val dialog = Dialog(this)
//            dialog.setContentView(R.layout.layout_dialog)
//
//            val c = Calendar.getInstance()
//            val mYear = c.get(Calendar.YEAR)
//            val mMonth = c.get(Calendar.MONTH)
//            val mDay = c.get(Calendar.DAY_OF_MONTH)
//            // month from 0 to 11
//            DatePickerDialog(this, {
//                _, year: Int, month: Int, day: Int -> Log.v("TAG", "$day - $month - $year")
//            }, mYear, mMonth, mDay).show()

//            TimePickerDialog(this, {
//                _, hour, minute -> Log.v("TAG", "$hour:$minute")
//            }, 10, 59, true).show()

//            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

            Snackbar.make(it, "button clicked", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", {})
                .show()
        }
    }
}