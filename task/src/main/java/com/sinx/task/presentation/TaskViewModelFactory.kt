package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinx.task.data.TaskRepositoryImpl
import com.sinx.task.model.GetTaskListUseCase
import com.sinx.task.model.TaskReadyUseCase

class TaskViewModelFactory : ViewModelProvider.Factory {

    private val repository = TaskRepositoryImpl()

    private val getTaskListUseCase = GetTaskListUseCase(repository)
    private val taskReadyUseCase = TaskReadyUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(getTaskListUseCase, taskReadyUseCase) as T
    }
}