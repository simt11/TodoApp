package com.sinx.task.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sinx.task.databinding.ItemTaskManagerBinding
import com.sinx.task.databinding.ItemTaskManagerIsDoneBinding
import com.sinx.task.model.TaskItem

class TaskItemViewHolder(
    val binding: ItemTaskManagerBinding,
    var listener: TaskListAdapter.OnTaskClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: TaskItem) {
        binding.textViewTask.text = task.name
        binding.textViewTaskDate.text = task.date
        binding.imageViewChangePosition.setOnClickListener {
            listener.onMoreItemClickListener(task)
        }
        binding.checkBoxTaskPriority.setOnCheckedChangeListener { button, b ->
            listener.onCheckBoxItemClickListener(task, binding.checkBoxTaskPriority.isChecked)
        }
    }
}

class TaskItemIsDoneViewHolder(
    val binding: ItemTaskManagerIsDoneBinding,
    var listener: TaskListAdapter.OnTaskClickListener

) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: TaskItem) {
        binding.textViewTask.text = task.name
        binding.textViewTaskDate.text = task.date
        binding.imageViewChangePosition.setOnClickListener {
            listener.onMoreItemClickListener(task)
        }
        binding.checkBoxTaskPriority.setOnCheckedChangeListener { button, b ->
            listener.onCheckBoxItemClickListener(task, binding.checkBoxTaskPriority.isChecked)
        }
    }
}