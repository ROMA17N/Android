package com.becla.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTask().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun changeTaskChecked (item: WellnessTask, checked: Any?) =
        _tasks.find{it.id == item.id }?.let{ tasks ->
            tasks.checked = checked as Boolean
    }

    fun remove(task: WellnessTask) {

    }
}

private fun getWellnessTask() = List(30) { i -> WellnessTask(i, "Task # $i") }