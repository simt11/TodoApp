package com.sinx.coreDB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sinx.coreDB.entity.TaskDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask (taskDB: TaskDbModel)

    @Query("SELECT * FROM task ORDER BY name")
    fun getTaskList() : Flow<List<TaskDbModel>>

    @Query("DELETE FROM task WHERE name")
    fun deleteTaskFromList (name: String)
}