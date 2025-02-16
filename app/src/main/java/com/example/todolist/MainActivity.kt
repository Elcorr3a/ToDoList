package com.example.todolist


import TareasListScreenCompleted
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.ui.AddTaskScreen
import com.example.todolist.ui.screens.TareasListScreen
import com.example.todolist.viewmodel.TareasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()  // Crear el NavController
            val viewModel = TareasViewModel()  // Instancia del ViewModel

            // Definir el NavHost con las rutas de navegación
            NavHost(navController = navController, startDestination = "tareas_list") {
                composable("tareas_list") {
                    TareasListScreen(viewModel = viewModel, navController = navController)
                }
                composable("add_task") {
                    AddTaskScreen(viewModel = viewModel, navController = navController)
                }
                composable("completed_tasks") {
                    TareasListScreenCompleted(viewModel = viewModel, navController = navController)
                }
            }
        }
    }
}
