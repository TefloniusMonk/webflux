package com.example.webflux.db.repository

import com.example.webflux.db.entity.Student
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class SimpleStudentRepository : StudentRepository {
    override fun findAll(): Flux<Student> {
        return Flux.just(
            Student(
                "Вася", 1L,
                mapOf(
                    "Русский язык" to 4,
                    "Математика" to 5,
                    "Литература" to 3,
                    "Естествознание" to 5,
                    "Функциональный анализ временных рядов" to 5,
                    "Основы проектирования летательных аппаратов" to 4
                ),

                ),
            Student(
                "Петя", 2L,
                mapOf(
                    "Русский язык" to 3,
                    "Математика" to 5,
                    "Литература" to 3,
                    "Естествознание" to 3,
                    "Квантовая механика" to 5,
                    "Методы оптимизации и численные методы" to 5
                ),

                ),
            Student(
                "Любочка", 3L,
                mapOf(
                    "Русский язык" to 5,
                    "Математика" to 5,
                    "Литература" to 5,
                    "Естествознание" to 5,
                    "Защита от темных искусств" to 5,
                    "Древние Руны" to 5,
                    "Зельеварение" to 5,
                ),

                ),
            Student(
                "Дмитрий Васильевич", 4L,
                mapOf(
                    "Русский язык" to 2,
                    "Математика" to 2,
                    "Литература" to 2,
                    "Естествознание" to 2,
                    "Пение" to 5,
                    "Физкультура" to 5
                )

            ),
        );
    }
}