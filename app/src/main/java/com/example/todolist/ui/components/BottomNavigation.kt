package com.example.tuapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Todas") },
            selected = true,
            onClick = {
                navController.navigate("tareas_list") // Ir a la lista de tareas
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Star, contentDescription = "Añadir Tarea") },
            selected = false,
            onClick = {
                navController.navigate("add_task") // Ir a la pantalla de añadir tareas
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Check, contentDescription = "Completadas") },
            selected = false,
            onClick = { navController.navigate("completed_tasks") }
        )
    }
}
