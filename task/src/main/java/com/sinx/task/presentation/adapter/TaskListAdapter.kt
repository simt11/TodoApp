package com.sinx.task.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sinx.task.databinding.ItemTaskManagerBinding
import com.sinx.task.model.TaskItem

class TaskListAdapter(var listener: OnTaskClickListener) :
    ListAdapter<TaskItem, TaskItemViewHolder>(TaskItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val binding = ItemTaskManagerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return TaskItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val task = getItem(position)
        holder.binding.textViewTask.text = task.name
        holder.binding.textViewTaskDate.text = task.date
        holder.binding.imageViewChangePosition.setOnClickListener {
            listener.onMoreItemClickListener(task)
        }
        holder.binding.checkBoxTaskPriority.setOnCheckedChangeListener { button, b ->
            listener.onCheckBoxItemClickListener(task, b)
        }
    }

    interface OnTaskClickListener {
        fun onMoreItemClickListener(item: TaskItem)
        fun onCheckBoxItemClickListener(item: TaskItem, isChecked: Boolean)
    }
}