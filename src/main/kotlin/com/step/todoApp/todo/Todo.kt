package com.step.todoApp.todo

class Todo( val id: Int,  var title: String) {
    private var taskId = 0;
    private val tasks = ArrayList<Task>()

    fun addTask(task: String): Boolean {
        return tasks.add(Task(++taskId, task))
    }

    override fun toString(): String {
        return "Todo(id=$id, title='$title',  tasks=$tasks)"
    }

    fun updateTitle(name: String): Boolean {
        this.title = name
        return true
    }

    fun getTasks(): ArrayList<Task> {
        return tasks
    }


}
