package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName


data class EnrollmentEntityFs(
    @get:PropertyName("cod") @set:PropertyName("cod") var cod: String = "",
    @get:PropertyName("yearS") @set:PropertyName("yearS") var yearS: String = "",
    @get:PropertyName("courseId") @set:PropertyName("courseId") var courseId: String = "",
    @get:PropertyName("studentId") @set:PropertyName("studentId") var studentId: String = ""
)