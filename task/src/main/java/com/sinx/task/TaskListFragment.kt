package com.sinx.task

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sinx.task.databinding.TaskListLayoutBinding

class TaskListFragment : Fragment() {
    private var _binding: TaskListLayoutBinding? = null
    private val binding: TaskListLayoutBinding
        get() = _binding ?: throw RuntimeException("TaskListLayoutBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = TaskListLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding) {
            addTask.setOnClickListener {
                val uri = Uri.parse("app://task/taskListFragment/addTaskFragment")
                findNavController().navigate(uri)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}