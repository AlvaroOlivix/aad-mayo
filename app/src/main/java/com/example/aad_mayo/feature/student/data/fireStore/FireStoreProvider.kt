package com.example.aad_mayo.feature.student.data.fireStore

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FireStoreProvider {

    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }
}