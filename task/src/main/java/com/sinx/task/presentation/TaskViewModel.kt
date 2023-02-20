package com.sinx.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinx.task.model.GetListUseCase
import com.sinx.task.model.TaskIsDoneUseCase
import com.sinx.task.model.TaskItem
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class TaskViewModel(
    private val getListUseCase: GetListUseCase,
    private val taskIsDoneUseCase: TaskIsDoneUseCase
) : ViewModel() {
    private val taskFlow = getListUseCase()

    private var _taskList = MutableSharedFlow<List<TaskItem>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    val taskList: SharedFlow<List<TaskItem>> = _taskList
    init {
        viewModelScope.launch {
            _taskList.emitAll(taskFlow)
        }
    }
    fun taskIsDone(item: TaskItem, isChecked: Boolean) {
        val newItem = item.copy(enabled = !isChecked)
        taskIsDoneUseCase(newItem)
        viewModelScope.launch {
            _taskList.emitAll(taskFlow)
        }
    }
}