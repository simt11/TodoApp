package com.sinx.task.model

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun taskIsDoneUseCase(item: TaskItem)

    fun getListUseCase(): Flow<List<TaskItem>>
}