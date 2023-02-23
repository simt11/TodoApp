package com.sinx.task.model

class GetTaskListUseCase(private val repository: TaskRepository) {

    operator fun invoke() = repository.getListUseCase()
}