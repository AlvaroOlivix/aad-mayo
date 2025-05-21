package com.example.aad_mayo.feature.student.data.fireStore

import com.example.aad_mayo.feature.student.data.fireStore.entities.CourseEntityFs
import com.example.aad_mayo.feature.student.data.fireStore.entities.EnrolledSubjectEfs
import com.example.aad_mayo.feature.student.data.fireStore.entities.EnrollmentEntityFs
import com.example.aad_mayo.feature.student.data.fireStore.entities.GroupEntotyFs
import com.example.aad_mayo.feature.student.data.fireStore.entities.StudentEntityFs
import com.example.aad_mayo.feature.student.data.fireStore.entities.SubjectEntityFs
import com.example.aad_mayo.feature.student.domain.Course
import com.example.aad_mayo.feature.student.domain.EnrolledSubject
import com.example.aad_mayo.feature.student.domain.Enrollment
import com.example.aad_mayo.feature.student.domain.Group
import com.example.aad_mayo.feature.student.domain.Student
import com.example.aad_mayo.feature.student.domain.Subject

    fun Student.toEntity(enrolledId: List<String>): StudentEntityFs = StudentEntityFs(
        expedient = this.expedient,
        name = this.name,
        subnames = this.subnames,
        bornYear = this.bornYear,
        enrolledsId = enrolledId
    )

    fun StudentEntityFs.toModel(enrolleds: List<EnrolledSubject>): Student = Student(
        expedient = this.expedient,
        name = this.name,
        subnames = this.subnames,
        bornYear = this.bornYear,
        enrolleds
    )

    fun EnrolledSubject.toEntity(subjectId: String): EnrolledSubjectEfs = EnrolledSubjectEfs(
        enrollmentId = this.enrollmentId,
        subjectId,
        grade = this.grade
    )

    fun EnrolledSubjectEfs.toModel(subject: Subject): EnrolledSubject = EnrolledSubject(
        enrollmentId = this.enrollmentId,
        subject,
        grade = this.grade
    )

    fun Enrollment.toEntity(courseId: String): EnrollmentEntityFs = EnrollmentEntityFs(
        cod = this.cod,
        yearS = this.yearS,
        courseId,
        studentId = this.studentId
    )

    fun EnrollmentEntityFs.toModel(course: Course): Enrollment = Enrollment(
        cod = this.cod,
        yearS = this.yearS,
        course,
        studentId = this.studentId
    )


    fun Group.toEntity(courseId: String): GroupEntotyFs = GroupEntotyFs(
        cod = this.cod,
        name = this.name,
        courseId
    )

    fun GroupEntotyFs.toModel(course: Course): Group = Group(
        cod = this.cod,
        name = this.name,
        course
    )

    fun Subject.toEntity(): SubjectEntityFs = SubjectEntityFs(
        cod = this.cod,
        name = this.name,
        desc = this.desc
    )

    fun SubjectEntityFs.toModel(): Subject = Subject(
        cod = this.cod,
        name = this.name,
        desc = this.desc
    )

    fun Course.toEntity(subjectsId: List<String>, groupId: List<String>): CourseEntityFs =
        CourseEntityFs(
            cod = this.cod,
            name = this.name,
            subjectsId,
            groupId
        )

    fun CourseEntityFs.toModel(subjects: List<Subject>, groups: List<Group>): Course = Course(
        cod = this.cod,
        name = this.name,
        subjects,
        groups
    )