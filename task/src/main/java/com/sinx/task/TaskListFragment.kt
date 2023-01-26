package com.sinx.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sinx.task.adapter.TaskListAdapter
import com.sinx.task.databinding.TaskListLayoutBinding
import com.sinx.task.model.TaskItem

class TaskListFragment : Fragment(R.layout.task_list_layout){



    private lateinit var taskListAdapter : TaskListAdapter

    private var _binding : TaskListLayoutBinding? = null
    private val binding : TaskListLayoutBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    private val taskList = createTaskList(20)

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
        taskListAdapter = TaskListAdapter(object : TaskListAdapter.OnTaskClickListener{
            override fun onMoreItemClickListener(item: TaskItem) {
            }

            override fun onCheckBoxItemClickListener(item: TaskItem, isChecked: Boolean) {
            }
        })
        binding.rvTaskList.adapter = taskListAdapter
        taskListAdapter.submitList(taskList)
    }

    private fun createTaskList(count:Int) = (0 .. count).map { i ->
        TaskItem(
            id=i,
            name = "Task Manager $i",
            date = "\"07 Jan 23 / Project\"",
            enabled = true,
            priority = 1
        )
    }
}