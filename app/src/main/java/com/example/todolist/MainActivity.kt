package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.screens.TareasScreen

import com.example.todolist.viewmodel.TareasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = TareasViewModel()
            val navController = rememberNavController()  // Crear el NavController
            TareasScreen(viewModel = viewModel, navController = navController)  // Pasar el NavController a TareasScreen
        }
    }
}
