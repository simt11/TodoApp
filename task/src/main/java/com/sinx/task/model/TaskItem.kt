package com.sinx.task.model

data class TaskItem(
    val id : Int = UNDEFINED_ID,
    val name : String,
    val date : String,
    val enabled: Boolean,
    val priority : Int
){
    companion object{
        val UNDEFINED_ID = -1
    }
}
