package com.example.aad_mayo.feature.student.data.room.db

import android.content.Context
import androidx.room.Room

object RoomProvider {
    fun providerRoom(context: Context): StudentDataBase {
        return Room.databaseBuilder(
            context,
            StudentDataBase::class.java, "database-student"
        ).build()
    }
}