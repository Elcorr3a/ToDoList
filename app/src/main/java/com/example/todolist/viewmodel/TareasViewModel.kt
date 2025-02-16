package com.example.todolist.viewmodel

import Tarea
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow



class TareasViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Tarea>>(generateSampleTasks())
    val tasks: StateFlow<List<Tarea>> get() = _tasks

    private val _completedTasks = MutableStateFlow<List<Tarea>>(emptyList())
    val completedTasks: StateFlow<List<Tarea>> get() = _completedTasks

    fun addTask(task: Tarea) {
        _tasks.value = _tasks.value + task
    }

    fun completeTask(task: Tarea) {
        _tasks.value = _tasks.value.filter { it.id != task.id }
        _completedTasks.value = _completedTasks.value + task.copy(completada = true)
    }

    fun uncompleteTask(task: Tarea) {
        _completedTasks.value = _completedTasks.value.filter { it.id != task.id }
        _tasks.value = _tasks.value + task.copy(completada = false)
    }

    private fun generateSampleTasks(): List<Tarea> {
        return listOf(
            Tarea(1, "Comprar leche", "Ir al supermercado", "18/02/2025", Prioridad.MEDIA),
            Tarea(2, "Estudiar Kotlin", "Repasar MVVM y Compose", "20/02/2025", Prioridad.ALTA),
            Tarea(3, "Hacer ejercicio", "Rutina de 30 min", "19/02/2025", Prioridad.BAJA)
        )
    }

    fun removeTask(task: Tarea) {
        _tasks.value = _tasks.value.filter { it.id != task.id }
    }
}
