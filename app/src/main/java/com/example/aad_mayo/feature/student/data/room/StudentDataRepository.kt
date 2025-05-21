package com.example.aad_mayo.feature.student.data.room

import com.example.aad_mayo.feature.student.domain.Student
import com.example.aad_mayo.feature.student.domain.StudentRepository

class StudentDataRepository(private val roomDataSource: LocalRoomDataSource) : StudentRepository {
    override suspend fun saveAll(students: List<Student>) {
        roomDataSource.saveAll(students)
    }

    override suspend fun getStudentByExp(expedient: String): Student? {
        return roomDataSource.getStudentByExp(expedient)
    }
}