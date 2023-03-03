package com.sinx.taskList.model

import com.sinx.taskList.TaskItem

class TaskReadyUseCaseImpl(private val repository: TaskRepository) : TaskReadyUseCase {

    override operator fun invoke(item: TaskItem) = repository.taskReady(item)
}

interface TaskReadyUseCase {
    operator fun invoke(item: TaskItem)
}