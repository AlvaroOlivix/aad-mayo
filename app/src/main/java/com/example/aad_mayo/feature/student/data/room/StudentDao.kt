package com.example.aad_mayo.feature.student.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(vararg students: StudentEntity)

    @Query("SELECT * FROM student_Table WHERE expedient == :sExpedient")
    fun getStudentByExp(sExpedient:String): StudentEntity
}