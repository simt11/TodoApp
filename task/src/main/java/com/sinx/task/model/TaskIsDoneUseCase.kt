package com.sinx.task.model

class TaskIsDoneUseCase(private val repository: TaskRepository) {

    operator fun invoke(item: TaskItem) = repository.taskIsDoneUseCase(item)
}