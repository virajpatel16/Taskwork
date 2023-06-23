package com.example.taskwork.Adepter

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskwork.Database.Task
import com.example.taskwork.Database.TaskData
import com.example.taskwork.Fragment.tasksFragment
import com.example.taskwork.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskAdepter(tasklist: ArrayList<Task>) : RecyclerView.Adapter<TaskAdepter.Taskholder>() {
    lateinit var context: Context
    var task = tasklist
    lateinit var db: TaskData

    class Taskholder(itemView: View) : ViewHolder(itemView) {

        var txttask = itemView.findViewById<TextView>(R.id.task)
        var addradio = itemView.findViewById<ImageView>(R.id.button)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Taskholder {
        context = parent.context
        return Taskholder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return task.size
    }

    override fun onBindViewHolder(holder: Taskholder, @SuppressLint("RecyclerView") position: Int) {

        holder.apply {
            txttask.text = task.get(position).task

addradio.setOnClickListener {


    if (task.get(position).check) {
        addradio.setImageResource(R.drawable.radio)
    } else {
        addradio.setImageResource(R.drawable.uncheckbutton)
    }
}
            holder.itemView.setOnLongClickListener(object : View.OnLongClickListener {
                override fun onLongClick(v: View?): Boolean {

                    var option = PopupMenu(holder.itemView.context, holder.itemView)
                    option.menuInflater.inflate(R.menu.data_item, option.menu)

                    option.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                        @RequiresApi(Build.VERSION_CODES.O)
                        override fun onMenuItemClick(item: MenuItem?): Boolean {


                            when (item?.itemId) {

                                R.id.delete -> {

                                    db.Tasks().deletetask(task[position])
                                    tasksFragment.update()

                                }

                                R.id.update -> {
                                    var dialog = Dialog(context)
                                    dialog.setContentView(R.layout.update_item)

                                    val formater =
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
                                    val current = LocalDateTime.now().format(formater)

                                    var edittask = dialog.findViewById<EditText>(R.id.edttask)
                                    var category = dialog.findViewById<EditText>(R.id.category)

                                     current
                                    edittask.setText(task[position].task)
                                    category.setText(task[position].category)

                                    dialog.show()


                                    var data = Task(
                                       current,
                                        edittask.text.toString(),
                                        category.text.toString(),
                                        false,
                                    )
                                    data.id = task[position].id

                                    db.Tasks().updatedata(data)
                                    dialog.dismiss()
                                    tasksFragment.update()

                                }
                            }
                            return true
                        }


                    })
                    return false
                }


            })


        }
    }
}