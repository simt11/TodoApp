package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinx.coredbinterface.dao.TaskDAO
import com.sinx.taskList.data.TaskRepositoryImpl
import com.sinx.taskList.model.GetTaskListUseCaseImpl
import com.sinx.taskList.model.TaskReadyUseCaseImpl

class TaskViewModelFactory(private val taskDAO: TaskDAO) : ViewModelProvider.Factory {

    private val repository = TaskRepositoryImpl(taskDAO)

    private val getTaskListUseCase = GetTaskListUseCaseImpl(repository)
    private val taskReadyUseCase = TaskReadyUseCaseImpl(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(getTaskListUseCase, taskReadyUseCase) as T
    }
}