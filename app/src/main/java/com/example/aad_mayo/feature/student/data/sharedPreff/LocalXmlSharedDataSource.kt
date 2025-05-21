package com.example.aad_mayo.feature.student.data.sharedPreff

import android.content.Context
import android.content.SharedPreferences
import com.example.aad_mayo.feature.student.domain.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LocalXmlSharedDataSource(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("student_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveStudentList(studentList: List<Student>) {
        val json = gson.toJson(studentList)
        sharedPreferences.edit().putString("students", json).apply()
    }

    fun getStudentByExpedient(expedient: String): Student? {
        val json = sharedPreferences.getString("students", null)
        if (json != null) {
            val type = object : TypeToken<List<Student>>() {}.type
            val studentList: List<Student> = gson.fromJson(json, type)
            return studentList.find { it.expedient == expedient }
        }
        return null
    }
}
