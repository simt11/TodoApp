package com.sinx.task.model

import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun taskReady(item: TaskItem)

    suspend fun listTasksFlow(): Flow<List<TaskItem>>
}