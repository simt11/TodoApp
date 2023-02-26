package com.sinx.task.model

import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun taskIsDoneUseCase(item: TaskItem)

    suspend fun listTasksFlow(): Flow<List<TaskItem>>
}