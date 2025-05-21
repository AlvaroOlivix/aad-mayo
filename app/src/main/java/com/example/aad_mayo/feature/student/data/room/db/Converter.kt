package com.example.aad_mayo.feature.student.data.room.db

import androidx.room.TypeConverter
import com.example.aad_mayo.feature.student.domain.EnrolledSubject
import com.example.aad_mayo.feature.student.domain.Enrollment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun enrollmentToData(enrollment: Enrollment): String {
        return gson.toJson(enrollment)
    }

    @TypeConverter
    fun dataToEnrollment(data: String): Enrollment {
        return gson.fromJson(data, Enrollment::class.java)
    }

    @TypeConverter
    fun enrolledSubToData(enrollS: EnrolledSubject): String {
        return gson.toJson(enrollS)
    }

    @TypeConverter
    fun dataToEnrolledS(data: String): EnrolledSubject {
        return gson.fromJson(data, EnrolledSubject::class.java)
    }

    @TypeConverter
    fun enrolledSubListToData(list: List<EnrolledSubject>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun dataToEnrolledSubList(data: String): List<EnrolledSubject> {
        val listType = object : TypeToken<List<EnrolledSubject>>() {}.type
        return gson.fromJson(data, listType)
    }

}