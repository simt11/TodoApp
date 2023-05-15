package com.sinx.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinx.project.data.ProjectRepositoryImpl
import com.sinx.project.domain.AddNewProjectRemoteUseCaseImpl
import com.sinx.project.domain.AddNewProjectUseCaseImpl
import com.sinx.project.domain.GetNewProjectUseCaseImpl

class ProjectViewModelFactory : ViewModelProvider.Factory {

    private val repository = ProjectRepositoryImpl()
    private val remoteRepository = ProjectRepositoryImpl()
    private val isNetworkAvailble = true

    private val addNewProjectUseCase =
        if (isNetworkAvailble) {
            AddNewProjectUseCaseImpl(repository)
        } else {
            AddNewProjectRemoteUseCaseImpl(remoteRepository)
        }

    private val getNewProjectUseCase = GetNewProjectUseCaseImpl(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProjectViewModel(addNewProjectUseCase, getNewProjectUseCase) as T
    }
}