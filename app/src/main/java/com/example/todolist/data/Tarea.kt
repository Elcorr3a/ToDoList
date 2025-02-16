data class Tarea(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val fechaFin: String,
    val prioridad: Prioridad,
    var completada: Boolean = false
)

enum class Prioridad {
    ALTA, MEDIA, BAJA
}

