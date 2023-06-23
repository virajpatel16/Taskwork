package com.example.taskwork.Fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskwork.Adepter.TaskAdepter
import com.example.taskwork.Database.Task
import com.example.taskwork.Database.TaskData
import com.example.taskwork.databinding.FragmentTasksBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class tasksFragment : Fragment() {
    lateinit var tasklist: ArrayList<Task>
    lateinit var binding: FragmentTasksBinding
    lateinit var db: TaskData



        @RequiresApi(Build.VERSION_CODES.O)
        val formater =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
        @RequiresApi(Build.VERSION_CODES.O)
        val current = LocalDateTime.now().format(formater)


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTasksBinding.inflate(layoutInflater)


current

        tasklist.sortByDescending {
            it.id
        }


db.Tasks().Display()
        binding.rcvdata.layoutManager = LinearLayoutManager(context)
        binding.rcvdata.adapter = TaskAdepter(tasklist)
        update()

        return binding.root
    }

    companion object {
        fun update() {
            lateinit var tasklist: ArrayList<Task>
            lateinit var db: TaskData
            var binding: FragmentTasksBinding
            var list = db.Tasks().Display()
            list = list.reversed()
            tasklist.clear()


        }
    }


}


