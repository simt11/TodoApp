package com.sinx.task.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sinx.task.model.TaskItem
import com.sinx.task.model.TaskRepository
import java.util.*
import kotlin.collections.ArrayList

class TaskRepositoryImpl() : TaskRepository {

    private val taskListLD = MutableLiveData<List<TaskItem>>()

    private var taskList = mutableListOf<TaskItem>()

    init {
        for(i in 0 .. 8){
            val item = TaskItem(
                id = i,
                name = "Task Manager $i",
                date = "\"07 Jan 23 / Project\"",
                enabled = true,
                priority = 1)
            addToList(item)
        }
    }

    private fun addToList (item: TaskItem) {
        taskList.add(item)
        taskListLD.value = taskList

    }

    override fun taskIsDoneUseCase(item: TaskItem) {
        val oldIndex =taskList.indexOfFirst { it.id == item.id }
        taskList = ArrayList(taskList)
        taskList.removeAt(oldIndex)
        val newItem = item.copy()
        taskList.add(newItem)
        taskListLD.value = taskList
    }

    override fun getListUseCase() : LiveData<List<TaskItem>> {
        return taskListLD
    }
}