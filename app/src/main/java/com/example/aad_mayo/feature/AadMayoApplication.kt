package com.example.aad_mayo.feature

import android.app.Application
import com.google.firebase.FirebaseApp


class AadMayoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

