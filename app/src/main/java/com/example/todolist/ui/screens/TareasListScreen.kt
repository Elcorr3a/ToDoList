package com.example.todolist.ui.screens

import SearchBarTopAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.viewmodel.TareasViewModel
import com.example.tuapp.ui.components.BottomNavigationBar
import androidx.compose.ui.Modifier
import com.example.tuapp.ui.components.TareaCard
@Composable
fun TareasListScreen(viewModel: TareasViewModel, navController: NavController) {
    val tareas by viewModel.filteredTasks.collectAsState()

    Scaffold(
        topBar = { SearchBarTopAppBar(viewModel) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            LazyColumn {
                items(tareas) { tarea ->
                    TareaCard(
                        tarea = tarea,
                        onCompletar = { viewModel.completeTask(tarea) },
                        onEliminar = { viewModel.removeTask(tarea) }
                    )
                }
            }
        }
    }
}
