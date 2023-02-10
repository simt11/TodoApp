package com.sinx.task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.sinx.task.presentation.adapter.TaskListAdapter
import com.sinx.task.databinding.TaskListLayoutBinding
import com.sinx.task.decoration.DividerItemDecorationTask
import com.sinx.task.model.TaskItem
import com.sinx.task.presentation.TaskViewModel
import java.util.Collections

import com.sinx.core.R as core_R

class TaskListFragment : Fragment(R.layout.task_list_layout) {

    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var viewModal: TaskViewModel

    private var _binding: TaskListLayoutBinding? = null
    private val binding: TaskListLayoutBinding
        get() = checkNotNull(_binding)


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
        setupListeners()
        taskListAdapter = TaskListAdapter(object : TaskListAdapter.OnTaskClickListener {
            override fun onMoreItemClickListener(item: TaskItem) {
//                TODO
            }

            override fun onCheckBoxItemClickListener(item: TaskItem, isChecked: Boolean) {
                viewModal.taskIsDone(item)
            }
        })
        binding.rvTaskList.adapter = taskListAdapter
        binding.rvTaskList.addItemDecoration(
            DividerItemDecorationTask(
                ContextCompat.getDrawable(requireContext(), core_R.drawable.divider)
            )
        )
        viewModal = ViewModelProvider(this)[TaskViewModel::class.java]
        viewModal.taskList.observe(viewLifecycleOwner){
            taskListAdapter.submitList(it)
        }

    }

    private fun setupListeners() {
        with(binding) {
            addTask.setOnClickListener {
                val request = NavDeepLinkRequest.Builder
                    .fromUri(ADD_TASK_URI.toUri())
                    .build()
                findNavController().navigate(request)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val item_number = 7
        private const val ADD_TASK_URI = "app://task/addTaskFragment"
    }
}