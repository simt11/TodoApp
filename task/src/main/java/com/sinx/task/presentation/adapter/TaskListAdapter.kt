package com.sinx.task.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sinx.task.databinding.ItemTaskManagerBinding
import com.sinx.task.databinding.ItemTaskManagerIsDoneBinding
import com.sinx.task.model.TaskItem

class TaskListAdapter(var listener: OnTaskClickListener) :
    ListAdapter<TaskItem, RecyclerView.ViewHolder>(TaskItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = when(viewType) {
            VIEW_TYPE_ENABLED -> TaskItemViewHolder(ItemTaskManagerBinding
                .inflate(LayoutInflater.from(parent.context), parent, false), listener)
            VIEW_TYPE_DISABLED -> TaskItemIsDoneViewHolder(ItemTaskManagerIsDoneBinding
                .inflate(LayoutInflater.from(parent.context), parent, false), listener)
            else ->throw RuntimeException ("unknown view type $viewType")
        }

        return binding
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val task = getItem(position)

        if (task.enabled) {
                (holder as TaskItemViewHolder).bind(task)
        } else {
            (holder as TaskItemIsDoneViewHolder).bind(task)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 0
        const val VIEW_TYPE_DISABLED = 1
    }

    interface OnTaskClickListener {
        fun onMoreItemClickListener(item: TaskItem)
        fun onCheckBoxItemClickListener(item: TaskItem, isChecked: Boolean)
    }
}