package com.example.webflux.db.entity

data class Student(
    val name: String = "",
    val id: Long = 0L,
    val grades: Map<String, Int> = HashMap()
)
