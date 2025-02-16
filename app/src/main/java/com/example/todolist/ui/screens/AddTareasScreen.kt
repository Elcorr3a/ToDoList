package com.example.todolist.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.todolist.viewmodel.TareasViewModel
import Tarea
import com.example.tuapp.ui.components.BottomNavigationBar
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(viewModel: TareasViewModel, navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }
    var prioridad by remember { mutableStateOf(Prioridad.BAJA) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController)},
        topBar = { TopAppBar(title = { Text("Añadir Tarea") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = fechaFin,
                onValueChange = { fechaFin = it },
                label = { Text("Fecha de finalización") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text("Prioridad:", style = MaterialTheme.typography.titleMedium)

            var expanded by remember { mutableStateOf(false) }
            Box {
                Button(onClick = { expanded = true }) {
                    Text(text = prioridad.name)
                }
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    Prioridad.values().forEach { pri ->
                        DropdownMenuItem(
                            text = { Text(pri.name) },
                            onClick = {
                                prioridad = pri
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (nombre.isNotEmpty() && descripcion.isNotEmpty() && fechaFin.isNotEmpty()) {
                        val newTask = Tarea(
                            id = UUID.randomUUID().hashCode(), // Genera un ID único
                            nombre = nombre,
                            descripcion = descripcion,
                            fechaFin = fechaFin,
                            prioridad = prioridad
                        )
                        viewModel.addTask(newTask)
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Añadir tarea")
            }
        }
    }
}

