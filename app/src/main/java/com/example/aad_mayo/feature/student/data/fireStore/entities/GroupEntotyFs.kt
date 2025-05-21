package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName


data class GroupEntotyFs(
    @get:PropertyName("cod") @set:PropertyName("cod") var cod: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("courseId") @set:PropertyName("courseId") var courseId: String = ""
)
