package com.example.aad_mayo.feature.student.domain

interface StudentRepository {
    fun saveAll(students:List<Student>)
    fun getStudentByExp(expedient: String): Student?
}