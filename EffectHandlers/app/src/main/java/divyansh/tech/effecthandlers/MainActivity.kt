package divyansh.tech.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import divyansh.tech.effecthandlers.ui.theme.EffectHandlersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var i by remember {
                mutableStateOf(0)
            }
            var sizeState by remember {
                mutableStateOf(100.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState,
                animationSpec = tween(
                    1000,
                    100
                )
            )
            Button(
                onClick = {
                    i++
                    sizeState = if (i % 2 == 0) 200.dp
                    else 100.dp
                },
                modifier = Modifier.padding(40.dp).size(size)
            ) {
                Text(text = "CLICKED $i times")
            }
        }
    }
}