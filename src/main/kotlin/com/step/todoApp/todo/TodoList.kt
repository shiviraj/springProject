package com.step.todoApp.todo

object TodoList {
    private val todoList = ArrayList<Todo>()
    private var id = 0;

    fun addTodo(name: String): Todo? {
        todoList.add(Todo(++id, name))
        return findById(id - 1)
    }

    fun addTask(todoId: Int, task: String): Boolean {
        return findById(todoId)?.addTask(task) ?: false
    }

    fun updateTitle(id: Int, name: String): Boolean {
        return findById(id)?.updateTitle(name) ?: false
    }

    fun getAllTodos(): List<String> {
        return todoList.map { it.title }
    }


    fun getAllTasks(todoId: Int): ArrayList<Task> {
        return findById(todoId)?.getTasks()!!
    }

    fun remove(todoId: Int): Boolean {
        return todoList.removeIf { it.id == todoId }
    }

    private fun findById(todoId: Int): Todo? {
        return todoList.find { it.id == todoId }
    }
}

