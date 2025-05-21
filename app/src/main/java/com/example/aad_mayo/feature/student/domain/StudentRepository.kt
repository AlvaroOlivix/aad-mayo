package com.example.aad_mayo.feature.student.domain

interface StudentRepository {
    suspend fun saveAll(students:List<Student>)
    suspend fun getStudentByExp(expedient: String): Student?
}