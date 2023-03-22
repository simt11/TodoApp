package com.sinx.task.data

import com.sinx.task.model.TaskRepository
import com.sinx.taskList.TaskItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class TaskRepositoryImpl : TaskRepository {

    private var taskList = mutableListOf<TaskItem>()

    private val taskFlow = MutableSharedFlow<List<TaskItem>>(replay = 1)
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun taskReady(item: TaskItem) {
        val oldIndex = taskList.indexOfFirst { it.name == item.name }
        taskList = taskList.toMutableList()
        taskList.removeAt(oldIndex)
        taskList.add(item)
        scope.launch {
            taskFlow.emit(taskList)
        }
    }

    override suspend fun listTasksFlow(): Flow<List<TaskItem>> {
        if (taskList.isEmpty()) {
            for (i in 0..item_number) {
                val item = TaskItem(
                    name = "Task Manager $i",
                    date = "\"07 Jan 23 / Project\"",
                    enabled = true,
                    priority = 1
                )
                taskList.add(item)
            }
        }
        taskFlow.emit(taskList)
        return taskFlow
    }

    companion object {
        private const val item_number = 7
    }
}