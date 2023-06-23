package com.example.taskwork.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskwork.Adepter.TaskAdepter
import com.example.taskwork.Database.Task
import com.example.taskwork.databinding.FragmentCalendarBinding


class calendarFragment : Fragment() {

    lateinit var binding:FragmentCalendarBinding
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView

    lateinit var taskday:Task
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding=FragmentCalendarBinding.inflate(layoutInflater)


        binding.calendarView.setOnDateChangeListener(object : CalendarView.OnDateChangeListener{
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {
                val Date = (dayOfMonth.toString() + "-"
                        + (month + 1) + "-" + year)

                binding.idTVDate.setText(Date)

            }

        })
//        binding.rcvday.layoutManager= LinearLayoutManager(context)
//        binding.rcvday.adapter=TaskAdepter(taskday)
        return binding.root
        }


}