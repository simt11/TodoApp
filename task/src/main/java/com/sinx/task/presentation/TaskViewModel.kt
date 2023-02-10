package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import com.sinx.task.data.TaskRepositoryImpl
import com.sinx.task.model.GetListUseCase
import com.sinx.task.model.TaskIsDoneUseCase
import com.sinx.task.model.TaskItem

class TaskViewModel(): ViewModel() {

    private val repository = TaskRepositoryImpl()

    private val getListUseCase = GetListUseCase(repository)
    private val taskIsDoneUseCase = TaskIsDoneUseCase(repository)

    val taskList = getListUseCase()

    fun taskIsDone (item: TaskItem) {
        taskIsDoneUseCase(item)
    }
}