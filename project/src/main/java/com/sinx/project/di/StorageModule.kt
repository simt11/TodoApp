package com.sinx.project.di

import com.sinx.project.domain.ProjectRepository
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    internal abstract fun provideProjectRepository(storage: ProjectRepository) : ProjectRepository
}