package com.example.aad_mayo.feature.student.data.room

import com.example.aad_mayo.feature.student.domain.Student

fun Student.toEntity(): StudentEntity =
    StudentEntity(this.expedient, this.name, this.subnames, this.bornYear, this.enrolleds)

fun StudentEntity.toDomain(): Student =
    Student(this.expedient, this.name, this.subnames, this.bornYear, this.enrolledS)