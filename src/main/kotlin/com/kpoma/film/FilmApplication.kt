package com.kpoma.film

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FilmApplication

fun main(args: Array<String>) {
    runApplication<FilmApplication>(*args)
}
