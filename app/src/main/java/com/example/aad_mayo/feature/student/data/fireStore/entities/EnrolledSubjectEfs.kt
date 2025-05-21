package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName

data class EnrolledSubjectEfs(
    @get:PropertyName("enrollmentId") @set:PropertyName("enrollmentId") var enrollmentId: String = "",
    @get:PropertyName("subjectId") @set:PropertyName("subjectId") var subjectId: String = "",
    @get:PropertyName("grade") @set:PropertyName("grade") var grade: String = ""
)