package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinx.task.data.TaskRepositoryImpl
import com.sinx.task.model.GetTaskListUseCaseImpl
import com.sinx.task.model.TaskReadyUseCaseImpl

class TaskViewModelFactory : ViewModelProvider.Factory {

    private val repository = TaskRepositoryImpl()

    private val getTaskListUseCase = GetTaskListUseCaseImpl(repository)
    private val taskReadyUseCase = TaskReadyUseCaseImpl(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(getTaskListUseCase, taskReadyUseCase) as T
    }
}