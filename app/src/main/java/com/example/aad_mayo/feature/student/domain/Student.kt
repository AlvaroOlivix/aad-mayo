package com.example.aad_mayo.feature.student.domain

data class Student(
    val expedient: String,
    val name: String,
    val subnames: String,
    val bornYear: String,
    val enrolleds: List<EnrolledSubject>
)

data class EnrolledSubject(val enrollmentId: String, val subject: Subject, val grade: String)
data class Subject(val cod: String, val name: String, val desc: String)
data class Course(
    val cod: String,
    val name: String,
    val subjects: List<Subject>,
    val groups: List<Group>
)

data class Group(val cod: String, val name: String, val course: Course)
data class Enrollment(val cod: String, val yearS: String, val course: Course, val studentId: String)
