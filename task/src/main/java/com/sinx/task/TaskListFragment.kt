package com.sinx.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sinx.task.adapter.TaskListAdapter
import com.sinx.task.databinding.TaskListLayoutBinding
import com.sinx.task.model.TaskItem

class TaskListFragment : Fragment(R.layout.task_list_layout) {

    private val taskListAdapter by lazy {
        TaskListAdapter()
    }

    private var _binding : TaskListLayoutBinding? = null
    private val binding : TaskListLayoutBinding
    get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    private val taskList = mutableListOf<TaskItem>()
    private var autoIncrementId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TaskListLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTaskList.adapter = taskListAdapter
        taskListAdapter.submitList(taskList)
    }

    init {
        for (i in 0 .. 20){
            val task = TaskItem(i, "Task Manager $i", "07 Jan 23 / Project", true, 1)
            addTask(task)
        }
    }
    private fun addTask (task: TaskItem) {
        if (task.id == TaskItem.UNDEFINED_ID) {
            task.id = autoIncrementId++
        }
        taskList.add(task)
    }
}