package com.sinx.task.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinx.task.data.TaskRepositoryImpl
import com.sinx.task.model.GetListUseCase
import com.sinx.task.model.TaskIsDoneUseCase
import com.sinx.task.model.TaskItem
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val repository = TaskRepositoryImpl()

    private val getListUseCase = GetListUseCase(repository)
    private val taskIsDoneUseCase = TaskIsDoneUseCase(repository)

    private val taskFlow = getListUseCase()

    private var _taskList = MutableSharedFlow<List<TaskItem>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    val taskList: SharedFlow<List<TaskItem>> = _taskList.asSharedFlow()
    init {
        viewModelScope.launch {
            _taskList.emitAll(taskFlow)
        }
    }
    fun taskIsDone(item: TaskItem, isChecked: Boolean){
        Log.d("test", isChecked.toString())
        val newItem = item.copy(enabled = isChecked)
        taskIsDoneUseCase(newItem)
    }
}