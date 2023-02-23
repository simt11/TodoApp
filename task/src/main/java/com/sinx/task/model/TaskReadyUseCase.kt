package com.sinx.task.model

class TaskReadyUseCase(private val repository: TaskRepository) {

    operator fun invoke(item: TaskItem) = repository.taskIsDoneUseCase(item)
}