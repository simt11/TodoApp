package com.sinx.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sinx.project.databinding.BottomSheetAddNewProjectBinding

class BottomSheetAddProjectFragment :
    BottomSheetDialogFragment(R.layout.bottom_sheet_add_new_project) {

    private var _binding: BottomSheetAddNewProjectBinding? = null
    private val binding: BottomSheetAddNewProjectBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetAddNewProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }
}