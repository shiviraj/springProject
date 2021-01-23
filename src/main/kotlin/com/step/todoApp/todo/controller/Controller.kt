package com.step.todoApp.todo.controller

import com.step.todoApp.todo.Task
import com.step.todoApp.todo.Todo
import com.step.todoApp.todo.TodoList
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/todos")
class Controller {

    @PostMapping("")
    fun addTodo(@RequestBody todoRequest: TodoRequest): Todo? {
        return TodoList.addTodo(todoRequest.name)
    }

    @GetMapping("")
    fun readAllTodos(): List<String> {
        return TodoList.getAllTodos()
    }

    @PutMapping("/{todoId}")
    fun updateTodoTitle(@RequestBody todoRequest: TodoRequest, @PathVariable todoId: Int): TodoResponse {
        val result = TodoList.updateTitle(todoId, todoRequest.name)
        return TodoResponse(result)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Int): TodoResponse {
        val response = TodoList.remove(todoId)
        return TodoResponse(response)
    }

    @GetMapping("/{todoId}")
    fun readTasks(@PathVariable todoId: Int): ArrayList<Task> {
        try {
            return TodoList.getAllTasks(todoId)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found")
        }
    }

    @PostMapping("/{todoId}/tasks")
    fun addTask(@RequestBody todoRequest: TodoRequest, @PathVariable todoId: Int): TodoResponse {
        val result = TodoList.addTask(todoId, todoRequest.name)
        return TodoResponse(result)
    }

    @GetMapping("/{todoId}/tasks")
    fun readTodo(@PathVariable todoId: Int): ArrayList<Task> {
        return TodoList.getAllTasks(todoId)
    }

}

