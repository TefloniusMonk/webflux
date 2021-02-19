package com.example.webflux

import com.example.webflux.db.entity.Student
import com.example.webflux.service.StudentService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StudentsIntegrationTest {
    @Autowired
    private lateinit var studentService: StudentService

    @Test
    fun shouldReturnAllStudents() {
        val result = studentService.getAllStudents().collectList().block()
        assertNotNull(result)
        assertEquals(4, result?.size)
    }

    @Test
    fun shouldCountAvgForStudents() {
        val result = studentService.getAvgForEachStudent().collectList().block()
        assertNotNull(result)
        assertEquals(4, result?.size)
        assertEquals(4.33, getAvgGradeByName(result, "Вася"), 0.1)
    }

    private fun getAvgGradeByName(result: List<Pair<Student, Double>>?, name: String) =
        result!!.stream().filter { pair -> pair.first.name == name }.findFirst().get().second
}