package com.example.webflux.service

import com.example.webflux.db.entity.Student
import reactor.core.publisher.Flux

interface StudentService {
    fun getAllStudents(): Flux<Student>
    fun getAvgForEachStudent(): Flux<Pair<Student, Double>>
}