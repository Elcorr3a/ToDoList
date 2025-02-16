package com.example.tuapp.ui.components

import Tarea
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun TareaCard(tarea: Tarea, onEliminar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = tarea.nombre, fontWeight = FontWeight.Bold)
            Text(text = tarea.descripcion)
            Text(text = "Fecha: ${tarea.fechaFin}")
            Text(text = "Prioridad: ${tarea.prioridad}")

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Button(onClick = onEliminar) {
                    Text("Eliminar")
                }
            }
        }
    }
}
