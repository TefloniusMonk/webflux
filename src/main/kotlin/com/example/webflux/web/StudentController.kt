package com.example.webflux.web

import com.example.webflux.db.entity.Student
import com.example.webflux.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/students")
class StudentController @Autowired constructor(val studentService: StudentService) {

    @GetMapping("/")
    fun findAll(): Flux<Student> {
        return studentService.getAllStudents();
    }

    @GetMapping("/avg")
    fun getAvgForStudents(): Flux<Pair<Student, Double>> {
        return studentService.getAvgForEachStudent();
    }
}