package com.example.aad_mayo.feature.student.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aad_mayo.feature.student.domain.EnrolledSubject
import com.example.aad_mayo.feature.student.domain.Enrollment


private const val STUDENT_TABLE = "student_Table"

@Entity(tableName = STUDENT_TABLE)
data class StudentEntity(
    @PrimaryKey @ColumnInfo(name = "expedient") val expedient: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "subnames") val subnames: String,
    @ColumnInfo(name = "bornYear") val bornYear:String,
    @ColumnInfo(name = "enrollment") val enrolledS: List<EnrolledSubject>
)
