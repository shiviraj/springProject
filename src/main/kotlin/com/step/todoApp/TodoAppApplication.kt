package com.step.todoApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoAppApplication

fun main(args: Array<String>) {
	println("Starting")
	runApplication<TodoAppApplication>(*args)
}
