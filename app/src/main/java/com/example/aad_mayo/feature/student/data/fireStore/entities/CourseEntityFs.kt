package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName

data class CourseEntityFs(
    @get:PropertyName("cod") @set:PropertyName("cod") var cod: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("subjectsId") @set:PropertyName("subjectsId") var subjectsId: List<String> = emptyList(),
    @get:PropertyName("groupsId") @set:PropertyName("groupsId") var groupsId: List<String> = emptyList()
)