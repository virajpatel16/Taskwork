package com.example.taskwork.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "task")
data class Task(

//    @ColumnInfo(name = "name")var name:String,
    @ColumnInfo(name = "date") var date:String,
    @ColumnInfo(name = "task") var task:String,
    @ColumnInfo(name = "category") var category:String,
    @ColumnInfo(name = "check") var check:Boolean,





    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}