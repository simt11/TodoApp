package com.sinx.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sinx.project.databinding.BottomSheetAddNewProjectBinding

class BottomSheetAddProjectFragment : BottomSheetDialogFragment(R.layout.bottom_sheet_add_new_project) {

    var _binding : BottomSheetAddNewProjectBinding? = null
    val binding : BottomSheetAddNewProjectBinding
    get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme)
    }

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