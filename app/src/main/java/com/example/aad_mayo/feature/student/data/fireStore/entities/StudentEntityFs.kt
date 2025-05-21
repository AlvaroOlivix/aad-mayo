package com.example.aad_mayo.feature.student.data.fireStore.entities

import com.google.firebase.firestore.PropertyName

data class StudentEntityFs(
    var expedient: String = "",
    var name: String = "",
    var subnames: String = "",
    var bornYear: String = "",
    var enrolledsId: List<String> = emptyList()
)








