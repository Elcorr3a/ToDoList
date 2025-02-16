package com.example.tuapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) { // Añadido el parámetro navController
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Todas") },
            label = { Text("Todas") },
            selected = true,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Star, contentDescription = "Añadir Tarea") },
            label = { Text("+") },
            selected = false,
            onClick = {
                // Navegar a la pantalla "add_task"
                navController.navigate("add_task")
            }
        )
    }
}
