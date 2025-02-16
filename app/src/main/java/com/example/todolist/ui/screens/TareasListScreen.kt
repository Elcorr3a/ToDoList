package com.example.todolist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.viewmodel.TareasViewModel
import com.example.tuapp.ui.components.BottomNavigationBar
import Tarea
import androidx.compose.ui.Modifier
import com.example.tuapp.ui.components.TareaCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TareasListScreen(viewModel: TareasViewModel, navController: NavController) {
    val tareas by viewModel.tasks.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Tareas") }) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn {
                items(tareas) { tarea ->
                    TareaCard(
                        tarea = tarea,
                        onCompletar = { viewModel.completeTask(tarea) },  // Llamar a la función para completar la tarea
                        onEliminar = { viewModel.removeTask(tarea) }      // Llamar a la función para eliminar la tarea
                    )
                }
            }
        }
    }
}

