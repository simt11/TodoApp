package com.sinx.task.data

import com.sinx.task.model.TaskItem
import com.sinx.task.model.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class TaskRepositoryImpl : TaskRepository {

    private var taskList = mutableListOf<TaskItem>()

    private val taskFlow = MutableSharedFlow<List<TaskItem>>()
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun taskIsDoneUseCase(item: TaskItem) {
        val oldIndex = taskList.indexOfFirst { it.id == item.id }
        taskList = ArrayList(taskList)
        taskList.removeAt(oldIndex)
        taskList.add(item)
        scope.launch {
            taskFlow.emit(taskList)
        }
    }

    override fun getListUseCase(): Flow<List<TaskItem>> {
        return flow {
            if (taskList.isEmpty()) {
                for (i in 0..item_number) {
                    val item = TaskItem(
                        id = i,
                        name = "Task Manager $i",
                        date = "\"07 Jan 23 / Project\"",
                        enabled = true,
                        priority = 1
                    )
                    taskList.add(item)
                }
                emit(taskList)
            } else {
                emitAll(taskFlow)
            }
        }
    }

    companion object {
        private const val item_number = 7
    }
}