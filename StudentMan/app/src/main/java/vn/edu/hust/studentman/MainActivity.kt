package vn.edu.hust.studentman

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
  private lateinit var studentAdapter: StudentAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val dialogAddView = LayoutInflater.from(this)
      .inflate(R.layout.layout_alert_dialog, null)

    val name = dialogAddView.findViewById<EditText>(R.id.student_name)
    val id = dialogAddView.findViewById<EditText>(R.id.student_id)

    val students = mutableListOf(
      StudentModel("Nguyễn Văn An", "SV001"),
      StudentModel("Trần Thị Bảo", "SV002"),
      StudentModel("Lê Hoàng Cường", "SV003"),
      StudentModel("Phạm Thị Dung", "SV004"),
      StudentModel("Đỗ Minh Đức", "SV005"),
      StudentModel("Vũ Thị Hoa", "SV006"),
      StudentModel("Hoàng Văn Hải", "SV007"),
      StudentModel("Bùi Thị Hạnh", "SV008"),
      StudentModel("Đinh Văn Hùng", "SV009"),
      StudentModel("Nguyễn Thị Linh", "SV010"),
      StudentModel("Phạm Văn Long", "SV011"),
      StudentModel("Trần Thị Mai", "SV012"),
      StudentModel("Lê Thị Ngọc", "SV013"),
      StudentModel("Vũ Văn Nam", "SV014"),
      StudentModel("Hoàng Thị Phương", "SV015"),
      StudentModel("Đỗ Văn Quân", "SV016"),
      StudentModel("Nguyễn Thị Thu", "SV017"),
      StudentModel("Trần Văn Tài", "SV018"),
      StudentModel("Phạm Thị Tuyết", "SV019"),
      StudentModel("Lê Văn Vũ", "SV020")
    )

    studentAdapter = StudentAdapter(
      students,
      onEditClick = {position ->
        val student = students[position]
        name.setText(student.studentName)
        id.setText(student.studentId)
        AlertDialog.Builder(this)
          .setTitle("Change student info")
          .setView(dialogAddView)
          .setPositiveButton("OK") {_, _, ->
            // change student var
            student.studentName = name.text.toString()
            student.studentId = id.text.toString()
            studentAdapter.notifyItemChanged(position)
            // show notification
            Toast.makeText(this, "Student info changed successfully", Toast.LENGTH_SHORT).show()
          }
          .setNegativeButton("Cancel", null)
          .show()
      },
      onRemoveClick = {position ->
        AlertDialog.Builder(this)
          .setTitle("Delete student?")
          .setPositiveButton("OK") {_, _ ->
            val removedStudent = students.removeAt(position)
            studentAdapter.notifyItemRemoved(position)
            Snackbar.make(findViewById(android.R.id.content), "Delete successfully", Snackbar.LENGTH_LONG)
              .setAction("UNDO") {
                students.add(position, removedStudent)
                studentAdapter.notifyItemInserted(position)
              }
              .show()
          }
          .setNegativeButton("Cancel", null)
          .show()
      },
    )

    findViewById<RecyclerView>(R.id.recycler_view_students).run {
      adapter = studentAdapter
      layoutManager = LinearLayoutManager(this@MainActivity)
    }

    // Add new student
    findViewById<Button>(R.id.btn_add_new).setOnClickListener {
      name.setText("")
      id.setText("")
      AlertDialog.Builder(this)
        .setTitle("Add new student")
        .setView(dialogAddView)
        .setPositiveButton("OK") {_, _ ->
          // add student
          val addedName = name.text.toString()
          val addedId = id.text.toString()
          students.add(StudentModel(addedName, addedId))
          studentAdapter.notifyItemInserted(students.size - 1)
          // show notification
          Toast.makeText(this, "Student added", Toast.LENGTH_SHORT).show()
        }
        .setNegativeButton("Cancel", null)
        .show()
    }
  }
}