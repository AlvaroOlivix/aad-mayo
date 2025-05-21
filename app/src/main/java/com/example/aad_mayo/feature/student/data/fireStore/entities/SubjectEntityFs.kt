package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName

data class SubjectEntityFs(
    @get:PropertyName("cod") @set:PropertyName("cod") var cod: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("desc") @set:PropertyName("desc") var desc: String = ""
)