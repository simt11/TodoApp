package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinx.task.data.TaskRepositoryImpl
import com.sinx.task.model.GetListUseCase
import com.sinx.task.model.TaskIsDoneUseCase

class TaskViewModelFactory : ViewModelProvider.Factory {

    private val repository = TaskRepositoryImpl()

    private val getListUseCase = GetListUseCase(repository)
    private val taskIsDoneUseCase = TaskIsDoneUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(getListUseCase, taskIsDoneUseCase) as T
    }
}