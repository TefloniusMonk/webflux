package com.example.webflux.service

import com.example.webflux.config.PropertyConfig
import com.example.webflux.db.entity.Student
import com.example.webflux.db.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import java.net.URI

@Service
class DefaultStudentService : StudentService {
    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var propertyConfig: PropertyConfig

    private var webClient: WebClient = WebClient.create()

    override fun getAllStudents(): Flux<Student> {
        return studentRepository.findAll()
    }

    override fun getAvgForEachStudent(): Flux<Pair<Student, Double>> {
        return webClient.get()
            .uri("${baseUrl()}/students/")
            .retrieve()
            .bodyToFlux(Student::class.java)
            .map { student -> Pair(student, avgGrade(student)) }
    }

    private fun avgGrade(student: Student) = student.grades.values.sum().toDouble() / student.grades.values.count()

    private fun baseUrl() = "${propertyConfig.baseUrl()}:${propertyConfig.basePort()}"
}