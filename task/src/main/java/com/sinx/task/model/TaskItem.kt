package com.sinx.task.model

data class TaskItem(
    var id : Int = UNDEFINED_ID,
    val name : String,
    val date : String,
    val enabled: Boolean,
    val priority : Int
){
    companion object{
        val UNDEFINED_ID = -1
    }
}
