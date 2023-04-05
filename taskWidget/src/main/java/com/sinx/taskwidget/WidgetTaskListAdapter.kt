package com.sinx.taskwidget

import android.content.Context
import android.view.View
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.sinx.taskList.TaskItem
import com.sinx.widgetTask.R

class WidgetTaskListAdapter(private val context: Context) : RemoteViewsService.RemoteViewsFactory {

    private var taskList = listOf<TaskItem>()

    override fun onCreate() {
        // todo
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onDataSetChanged() {
        taskList = getTaskList()
    }

    override fun onDestroy() {
        // todo
    }

    override fun getViewAt(position: Int): RemoteViews {
        val task = taskList[position]
        val remoteViews = RemoteViews(context.packageName, R.layout.item_task_list)

        remoteViews.setTextViewText(R.id.task_name, task.name)
        remoteViews.setTextViewText(R.id.task_date, task.date)
        remoteViews.setViewVisibility(R.id.task_checkbox, View.VISIBLE)

        return remoteViews
    }

    override fun getCount(): Int {
        return taskList.size
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    @Suppress("MagicNumber")
    private fun getTaskList() = (0..20).map { i ->
        TaskItem("Task Manager ${i + 1}", "01 Jan 23", true, 1)
    }
}