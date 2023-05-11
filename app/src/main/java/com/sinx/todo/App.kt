package com.sinx.todo

import android.app.Application
import com.sinx.coreDB.di.DbModule
import com.sinx.coredbinterface.DbProvider
import com.sinx.coredbinterface.dao.ProjectDAO
import com.sinx.coredbinterface.dao.TaskDAO

class App : Application(), DbProvider {

    private val dbModule = DbModule()
    private val appDB by lazy { dbModule.provideToDoAppDatabase(this) }

    override fun getProjectDao(): ProjectDAO {
        return dbModule.provideProjectDao(appDB)
    }

    override fun getTaskDAO(): TaskDAO {
        return dbModule.provideTaskDao(appDB)
    }
}