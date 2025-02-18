package com.example.todolist.viewmodel
import Tarea
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class TareasViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Tarea>>(generateSampleTasks())
    val tasks: StateFlow<List<Tarea>> get() = _tasks

    private val _completedTasks = MutableStateFlow<List<Tarea>>(emptyList())
    val completedTasks: StateFlow<List<Tarea>> get() = _completedTasks

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> get() = _searchQuery

    val filteredTasks = combine(_tasks, _searchQuery) { tareas, query ->
        if (query.isBlank()) {
            tareas
        } else {
            tareas.filter { tarea ->
                tarea.nombre.contains(query, ignoreCase = true) ||
                        tarea.descripcion.contains(query, ignoreCase = true)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, _tasks.value)

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun addTask(task: Tarea) {
        _tasks.value += task
    }

    fun completeTask(task: Tarea) {
        _tasks.value = _tasks.value.filter { it.id != task.id }
        _completedTasks.value = _completedTasks.value + task.copy(completada = true)
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
