import androidx.compose.runtime.mutableStateListOf

class TareasRepository {
    private val tareas = mutableStateListOf<Tarea>()

    init {
        generarTareasIniciales()
    }

    private fun generarTareasIniciales() {
        tareas.addAll(
            listOf(
                Tarea(1, "Comprar comida", "Ir al supermercado", "2025-02-20", Prioridad.ALTA),
                Tarea(2, "Hacer ejercicio", "Entrenar 1 hora", "2025-02-17", Prioridad.MEDIA),
                Tarea(3, "Estudiar Kotlin", "Repasar MVVM", "2025-02-18", Prioridad.BAJA)
            )
        )
    }

    fun obtenerTareas(): List<Tarea> = tareas

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
    }

    fun eliminarTarea(id: Int) {
        tareas.removeIf { it.id == id }
    }

    fun marcarComoCompletada(id: Int) {
        tareas.find { it.id == id }?.completada = true
    }
}
