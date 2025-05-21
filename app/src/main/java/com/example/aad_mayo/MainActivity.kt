package com.example.aad_mayo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_mayo.feature.student.data.fireStore.FireStoreProvider
import com.example.aad_mayo.feature.student.data.fireStore.RemoteFSDataSource
import com.example.aad_mayo.feature.student.data.fireStore.StudentFireBaseDataRepository
import com.example.aad_mayo.feature.student.data.room.StudentDataRepository
import com.example.aad_mayo.feature.student.data.room.LocalRoomDataSource
import com.example.aad_mayo.feature.student.data.room.db.RoomProvider
import com.example.aad_mayo.feature.student.data.sharedP.LocalXmlSharedDataSource
import com.example.aad_mayo.feature.student.data.sharedP.StudentSharedDataRepository
import com.example.aad_mayo.feature.student.domain.Course
import com.example.aad_mayo.feature.student.domain.EnrolledSubject
import com.example.aad_mayo.feature.student.domain.Enrollment
import com.example.aad_mayo.feature.student.domain.Student
import com.example.aad_mayo.feature.student.domain.Subject
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initFireStore()
        //initShared()
        //initRoom()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun initFireStore() {
        val subject1 = Subject("MAT101", "Matemáticas", "Álgebra y funciones")
        val subject2 = Subject("HIS101", "Historia", "Historia universal moderna")
        val subject3 = Subject("BIO101", "Biología", "Fundamentos de biología celular")

        val course = Course(
            cod = "CURS2024",
            name = "1º Curso Ciencias",
            subjects = listOf(subject1, subject2, subject3),
            groups = emptyList()
        )

        val enrollment = Enrollment(
            cod = "ENR001",
            yearS = "2024-2025",
            course = course,
            studentId = "EXP001"
        )
        val enrollment2 = Enrollment(
            cod = "ENR002",
            yearS = "2024-2025",
            course = course,
            studentId = "Exp003"
        )

        val enrolleds = listOf(
            EnrolledSubject(
                enrollment.cod,
                subject1,
                "7"
            ), EnrolledSubject(
                enrollment.cod,
                subject2,
                "6"
            ), EnrolledSubject(
                enrollment.cod,
                subject3,
                "6"
            )
        )
        val enrolleds2 = listOf(
            EnrolledSubject(
                enrollment2.cod,
                subject1,
                "No evaluado"
            ),
            EnrolledSubject(
                enrollment2.cod,
                subject2,
                "8"
            ), EnrolledSubject(
                enrollment2.cod,
                subject3,
                "6"
            )
        )
        val mockStudents = listOf(
            Student(
                "EXP001",
                "Lucía",
                "Pérez Ramírez",
                "2006",
                enrolleds
            ),
            Student(
                "Exp003",
                "Marcos",
                "Alonso",
                "2004",
                enrolleds2
            )
        )

        val fs = FireStoreProvider.provideFirestore()
        val fbDataSource = RemoteFSDataSource(fs)
        val repo = StudentFireBaseDataRepository(fbDataSource)

        GlobalScope.launch {
            repo.saveAll(mockStudents)

            //Aparece en local que recoge los datos pero no los llega a guardar en FireStore
        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun initShared() {
        val subject1 = Subject("MAT101", "Matemáticas", "Álgebra y funciones")
        val subject2 = Subject("HIS101", "Historia", "Historia universal moderna")
        val subject3 = Subject("BIO101", "Biología", "Fundamentos de biología celular")

        val course = Course(
            cod = "CURS2024",
            name = "1º Curso Ciencias",
            subjects = listOf(subject1, subject2, subject3),
            groups = emptyList()
        )

        val enrollment = Enrollment(
            cod = "ENR001",
            yearS = "2024-2025",
            course = course,
            studentId = "EXP001"
        )
        val enrollment2 = Enrollment(
            cod = "ENR002",
            yearS = "2024-2025",
            course = course,
            studentId = "Exp003"
        )

        val enrolleds = listOf(
            EnrolledSubject(
                enrollment.cod,
                subject1,
                "7"
            ), EnrolledSubject(
                enrollment.cod,
                subject2,
                "6"
            ), EnrolledSubject(
                enrollment.cod,
                subject3,
                "6"
            )
        )
        val enrolleds2 = listOf(
            EnrolledSubject(
                enrollment2.cod,
                subject1,
                "No evaluado"
            ),
            EnrolledSubject(
                enrollment2.cod,
                subject2,
                "8"
            ), EnrolledSubject(
                enrollment2.cod,
                subject3,
                "6"
            )
        )
        val mockStudents = listOf(
            Student(
                "EXP001",
                "Lucía",
                "Pérez Ramírez",
                "2006",
                enrolleds
            ),
            Student(
                "Exp003",
                "Marcos",
                "Alonso",
                "2004",
                enrolleds2
            )
        )

        val localXmlSharedDataSource = LocalXmlSharedDataSource(this)
        val repo = StudentSharedDataRepository(localXmlSharedDataSource)

        GlobalScope.launch {

            repo.saveAll(mockStudents)
            Log.d("@shd", repo.getStudentByExp("EXP001").toString())
            Log.d("@shd", repo.getStudentByExp("Exp003").toString())
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun initRoom() {


        val subject1 = Subject("MAT101", "Matemáticas", "Álgebra y funciones")
        val subject2 = Subject("HIS101", "Historia", "Historia universal moderna")
        val subject3 = Subject("BIO101", "Biología", "Fundamentos de biología celular")

        val course = Course(
            cod = "CURS2024",
            name = "1º Curso Ciencias",
            subjects = listOf(subject1, subject2, subject3),
            groups = emptyList()
        )

        val enrollment = Enrollment(
            cod = "ENR001",
            yearS = "2024-2025",
            course = course,
            studentId = "EXP001"
        )
        val enrollment2 = Enrollment(
            cod = "ENR002",
            yearS = "2024-2025",
            course = course,
            studentId = "Exp003"
        )

        val enrolleds = listOf(
            EnrolledSubject(
                enrollment.cod,
                subject1,
                "7"
            ), EnrolledSubject(
                enrollment.cod,
                subject2,
                "6"
            ), EnrolledSubject(
                enrollment.cod,
                subject3,
                "6"
            )
        )
        val enrolleds2 = listOf(
            EnrolledSubject(
                enrollment2.cod,
                subject1,
                "No evaluado"
            ),
            EnrolledSubject(
                enrollment2.cod,
                subject2,
                "8"
            ), EnrolledSubject(
                enrollment2.cod,
                subject3,
                "6"
            )
        )
        val mockStudents = listOf(
            Student(
                "EXP001",
                "Lucía",
                "Pérez Ramírez",
                "2006",
                enrolleds
            ),
            Student(
                "Exp003",
                "Marcos",
                "Alonso",
                "2004",
                enrolleds2
            )
        )

        val db = RoomProvider.providerRoom(this@MainActivity)
        val studentDao = db.studentDao()
        val roomDataSource = LocalRoomDataSource(studentDao)
        val repo = StudentDataRepository(roomDataSource)

        GlobalScope.launch {
            repo.saveAll(mockStudents)
            Log.d("@dev", repo.getStudentByExp("EXP001").toString())
            Log.d("@dev", repo.getStudentByExp("Exp003").toString())
        }
    }
}