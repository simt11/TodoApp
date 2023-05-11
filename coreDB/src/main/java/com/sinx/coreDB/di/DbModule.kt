package com.sinx.coreDB.di

import android.content.Context
import com.sinx.coreDB.ToDoAppDatabase
import com.sinx.coredbinterface.dao.ProjectDAO
import com.sinx.coredbinterface.dao.TaskDAO

class DbModule {

    fun provideToDoAppDatabase(context: Context): ToDoAppDatabase {
        return ToDoAppDatabase.getInstance(context)
    }

    fun provideTaskDao(appDatabase: ToDoAppDatabase): TaskDAO {
        return appDatabase.taskDao()
    }

    fun provideProjectDao(appDatabase: ToDoAppDatabase): ProjectDAO {
        return appDatabase.projectDao()
    }
}