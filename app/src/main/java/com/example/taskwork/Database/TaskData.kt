package com.example.taskwork.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskData : RoomDatabase() {

    companion object {


        fun getdata(context: Context): TaskData {
            var db = Room.databaseBuilder(context, TaskData::class.java, "task.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return db
        }
    }

    abstract fun Tasks(): Taskdao

}