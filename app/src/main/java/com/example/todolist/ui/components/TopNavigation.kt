import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.viewmodel.TareasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarTopAppBar(viewModel: TareasViewModel) {
    var text by remember { mutableStateOf("") }

    TopAppBar(
        title = {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    viewModel.setSearchQuery(it)
                },
                placeholder = { Text("Buscar tarea...") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = Modifier.padding(8.dp)
    )
}
