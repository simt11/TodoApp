package com.sinx.task.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface TaskRepository {

    fun taskIsDoneUseCase (item: TaskItem)

    fun getListUseCase () : LiveData<List<TaskItem>>
}