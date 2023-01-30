package com.sinx.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinx.project.adapter.ProjectListAdapter
import com.sinx.project.data.ProjectListModel
import com.sinx.project.databinding.ProjectLayoutBinding
import com.sinx.project.decoration.DividerItemDecoration
import com.sinx.core.R as core_R

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
        binding.rvProjectList.addItemDecoration(
            DividerItemDecoration(
                ContextCompat.getDrawable(requireContext(), core_R.drawable.divider)
            )
        )

        binding.projectAddNew.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("app://project.BottomSheetAddProjectFragment".toUri())
                .build()
            findNavController().navigate(request)
        }

        return binding.root
    }

    @Suppress("MagicNumber")
    private fun dataListProject() = (0..20).map { i ->
        ProjectListModel("Project Main ${i + 1}", "07 Jan 23")
    }
}