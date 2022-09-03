package divyansh.tech.ultimateguidetostates

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var counter by mutableStateOf(0)

    fun increment() {
        counter += 1
    }

    fun decrement() {
        counter -= 1
    }
}