package com.example.aad_mayo.feature.student.data.fireStore

import com.example.aad_mayo.feature.student.domain.Student
import com.example.aad_mayo.feature.student.domain.StudentRepository

class StudentFireBaseDataRepository(private val fsData: RemoteFSDataSource) : StudentRepository {
    override suspend fun saveAll(students: List<Student>) {
        fsData.saveAll(students)
    }

    override suspend fun getStudentByExp(expedient: String): Student? {
        return fsData.getStudentByExpedient(expedient)
    }
}