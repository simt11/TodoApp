package com.sinx.task.model

class TaskReadyUseCaseImpl(private val repository: TaskRepository) : TaskReadyUseCase {

    override operator fun invoke(item: TaskItem) = repository.taskReady(item)
}

interface TaskReadyUseCase {
    operator fun invoke(item: TaskItem)
}