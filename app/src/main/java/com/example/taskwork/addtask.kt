package com.example.taskwork

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.taskwork.Database.Task
import com.example.taskwork.Database.TaskData
import com.example.taskwork.databinding.ActivityAddtaskBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class addtask : AppCompatActivity() {
    lateinit var binding: ActivityAddtaskBinding
    lateinit var db: TaskData

    @SuppressLint("ResourceType", "SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddtaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        db = TaskData.getdata(this)
        binding.calender.setOnClickListener {

            var dialog = Dialog(this)
            dialog.setContentView(R.layout.cal_item)

            dialog.show()

        }
        reminder()

        binding.taskadd.setOnClickListener {
            var format = DateTimeFormatter.ofPattern("yyyy-mm-dd  HH:MM:SS a")
            var current = LocalDateTime.now().format(format)



            var task = Task(


                current,
                binding.addtask.text.toString(),

                binding.edtcategory.text.toString(), false
            )

            db.Tasks().Insert(task)
        }
        finish()
    }


    private fun reminder() {
        val startTime = "2022-02-1T09:00:00"
        val endTime = "2022-02-1T12:00:00"

        val mSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val mStartTime = mSimpleDateFormat.parse(startTime)
        val mEndTime = mSimpleDateFormat.parse(endTime)
        binding.reminder.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_EDIT)
            mIntent.type = "vnd.android.cursor.item/event"
            mIntent.putExtra("beginTime", mStartTime.time)
            mIntent.putExtra("time", true)
            mIntent.putExtra("rule", "FREQ=YEARLY")
            mIntent.putExtra("endTime", mEndTime.time)
            mIntent.putExtra("title", "Geeksforgeeks Event")
            startActivity(mIntent)
        }
    }
}