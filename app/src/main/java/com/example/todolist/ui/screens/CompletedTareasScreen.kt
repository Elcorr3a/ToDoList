
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.viewmodel.TareasViewModel
import com.example.tuapp.ui.components.BottomNavigationBar
import com.example.tuapp.ui.components.TareaCard



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TareasListScreenCompleted(viewModel: TareasViewModel, navController: NavController) {
    val tareas by viewModel.completedTasks.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Tareas Completadas") },
                modifier = Modifier.padding(8.dp) // Agrega padding a la TopAppBar
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
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
