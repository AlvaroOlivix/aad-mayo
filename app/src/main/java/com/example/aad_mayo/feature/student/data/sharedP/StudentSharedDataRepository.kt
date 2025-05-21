package com.example.aad_mayo.feature.student.data.sharedP

import com.example.aad_mayo.feature.student.domain.Student
import com.example.aad_mayo.feature.student.domain.StudentRepository

class StudentSharedDataRepository(private val localXml: LocalXmlSharedDataSource) :
    StudentRepository {
    override fun saveAll(students: List<Student>) {
        localXml.saveStudentList(students)
    }

    override fun getStudentByExp(expedient: String): Student? {
        return localXml.getStudentByExpedient(expedient)
    }
}