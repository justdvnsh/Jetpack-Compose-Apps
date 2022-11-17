package divyansh.tech.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import divyansh.tech.effecthandlers.ui.theme.EffectHandlersTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel by viewModels<MainViewModel>()

            LaunchedEffect(true) {
                mainViewModel.fakeAPICallInitial()
            }

            val scope = rememberCoroutineScope()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(text = mainViewModel.counterState.value.toString(), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)

                Spacer(modifier = Modifier.padding(vertical = 20.dp))

                Row(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        scope.launch {
                            mainViewModel.fakeAPICallForIncrement()
                        }
                    }) {
                        Text(text = "Increment", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                    }

                    Button(onClick = {
                        scope.launch {
                            mainViewModel.fakeAPICallForDecrement()
                        }
                    }) {
                        Text(text = "Decrement", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}