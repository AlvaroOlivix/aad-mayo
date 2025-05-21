package com.example.aad_mayo.feature.student.data.room

import com.example.aad_mayo.feature.student.domain.Student

class LocalRoomDataSource(private val studentDao: StudentDao) {

    fun saveAll(students: List<Student>) {
        studentDao.saveAll(*students.map { it.toEntity() }.toTypedArray())
    }

    fun getStudentByExp(expedient: String): Student? {
        return studentDao.getStudentByExp(expedient).toDomain()
    }

}