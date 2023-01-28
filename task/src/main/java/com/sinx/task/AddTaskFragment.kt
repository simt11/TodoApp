package com.sinx.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import com.sinx.task.databinding.AddTaskLayoutBinding

class AddTaskFragment : Fragment() {
    private var _binding: AddTaskLayoutBinding? = null
    private val binding: AddTaskLayoutBinding
        get() = _binding ?: throw RuntimeException("AddTaskLayoutBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AddTaskLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding) {
            selectedProject.text = "No project"
            selectedPriority.setBackgroundColor(getColor(requireContext(), com.sinx.core.R.color.grey))
            selectedRepeat.text = "No"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}