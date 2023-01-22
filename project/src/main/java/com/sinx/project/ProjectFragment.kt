package com.sinx.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinx.project.adapter.ProjectListAdapter
import com.sinx.project.data.ProjectListModel
import com.sinx.project.databinding.ProjectLayoutBinding

class ProjectFragment : Fragment(R.layout.project_layout) {
    lateinit var binding: ProjectLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectLayoutBinding.inflate(layoutInflater)

        binding.rvProjectList.layoutManager = LinearLayoutManager(context)
        binding.rvProjectList.adapter = ProjectListAdapter(dataListProject())

        return binding.root
    }

    private fun dataListProject(): ArrayList<ProjectListModel> {
        val projectListModels = ArrayList<ProjectListModel>()
        var count = 1
        for (i in 0..100) {
            projectListModels.add(ProjectListModel("Project Main ${count++}", "01.02.2023"))
        }
        return projectListModels
    }
}