package com.example.taskwork.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Taskdao {

    @Insert
    fun Insert(task: Task)

    @Query("SELECT * FROM task")
    fun Display() : List<Task>

    @Update
    fun updatedata(task: Task)

    @Delete
    fun deletetask(task: Task)
}