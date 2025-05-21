package com.example.aad_mayo.feature.student.data.fireStore

import android.util.Log
import com.example.aad_mayo.feature.student.data.fireStore.entities.StudentEntityFs
import com.example.aad_mayo.feature.student.data.room.toEntity
import com.example.aad_mayo.feature.student.domain.Student
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await

class RemoteFSDataSource(private val firestore: FirebaseFirestore) {

    private val collStudents = firestore.collection("Students")
    val collSubjects = firestore.collection("Subjects")
    //Otras colecciones del resto de modelos
    //Sus respectivos saves para aportar los datos necesarios para definir en los mapper, toModel y toEntity


    suspend fun saveAll(students: List<Student>) {
        students.forEach { student ->
            val entity = student.toEntity()
            Log.d("SAVE_STUDENT", "Saving entity: $entity")
            collStudents.document(student.expedient)
                .set(entity)
                .await()
        }
    }

        suspend fun getStudentByExpedient(expedient: String) :Student?{
            val snap =collStudents.document(expedient)
                .get().await()
            val entity = snap.toObject(StudentEntityFs::class.java)
            return null  //entity?.toModel()
            //Falta hacer el save de la lista de emrollMents para trminar el get
        }

}