package divyansh.tech.effecthandlers

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val counterState = mutableStateOf(0)

    fun fakeAPICallInitial() {
        Log.e("INITIAL -> ", "Initial API BEING Called")
    }

    suspend fun fakeAPICallForIncrement() {
        delay(200)
        Log.e("INCREMENT -> ", "FAKE DATA CALLED FOR INCREMENT")
        counterState.value += 1
    }

    suspend fun fakeAPICallForDecrement() {
        delay(200)
        Log.e("DECREMENT -> ", "FAKE DATA CALLED FOR DECREMENT")
        counterState.value -= 1
    }
}