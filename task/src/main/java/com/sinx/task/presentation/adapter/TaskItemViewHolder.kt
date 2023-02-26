package com.sinx.task.presentation.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sinx.task.databinding.ItemTaskManagerBinding
import com.sinx.task.databinding.ItemTaskManagerIsDoneBinding
import com.sinx.task.model.TaskItem

class TaskItemViewHolder(
    private val binding: ItemTaskManagerBinding,
    private var listener: TaskListAdapter.OnTaskClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: TaskItem) = with(binding) {
        textViewTask.isEnabled = task.enabled
        textViewTask.text = task.name
        textViewTaskDate.text = task.date
        textViewTaskDate.isEnabled = task.enabled
        checkBoxTaskPriority.isEnabled = task.enabled
        imageViewChangePosition.isVisible = task.enabled
        checkBoxTaskPriority.setOnCheckedChangeListener { _, _ -> }
        checkBoxTaskPriority.isChecked = !task.enabled
        imageViewChangePosition.setOnClickListener {
            listener.onMoreItemClickListener(task)
        }
        if (task.enabled) {
            checkBoxTaskPriority.setOnCheckedChangeListener { button, b ->
                listener.onCheckBoxItemClickListener(task, binding.checkBoxTaskPriority.isChecked)
            }
        }
    }
}

class TaskItemIsDoneViewHolder(
    val binding: ItemTaskManagerIsDoneBinding,
    var listener: TaskListAdapter.OnTaskClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: TaskItem) = with(binding) {
        textViewTask.text = task.name
        textViewTaskDate.text = task.date
        imageViewChangePosition.setOnClickListener {
            listener.onMoreItemClickListener(task)
        }
    }
}