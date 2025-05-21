package com.example.aad_mayo.feature.student.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.aad_mayo.feature.student.data.room.StudentDao
import com.example.aad_mayo.feature.student.data.room.StudentEntity

@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}