package com.sinx.task.model

class GetListUseCase (private val repository: TaskRepository) {

    operator fun invoke () = repository.getListUseCase()
}