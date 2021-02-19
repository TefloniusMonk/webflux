package com.example.webflux.db.repository

import com.example.webflux.db.entity.Student
import reactor.core.publisher.Flux

interface StudentRepository {
    fun findAll(): Flux<Student>
}