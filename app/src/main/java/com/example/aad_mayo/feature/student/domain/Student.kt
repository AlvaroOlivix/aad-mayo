package com.example.aad_mayo.feature.student.domain

import java.security.Signature

data class Student(val expedient:String, val name: String, val subnames:String, val bornYear:String, val ratings: List<Rating>)
data class Subject(val cod:String, val name:String, val desc:String)
data class Course(val cod:String, val name:String, val subjects:List<Subject>, val groups:List<Group>)
data class Group(val cod:String, val name:String, val course:Course)
data class Enrollment(val cod:String, val yearS:String, val course: Course, val student: Student)
data class Rating(val expedientId:String, val subjectId:String, val courseId:String, val nota:String )