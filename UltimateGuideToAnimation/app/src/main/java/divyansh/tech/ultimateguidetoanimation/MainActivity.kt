package divyansh.tech.ultimateguidetoanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import divyansh.tech.ultimateguidetoanimation.ui.theme.UltimateGuideToAnimationTheme

enum class STATE {COLLAPSED, EXPANDED}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLoading by remember {
                mutableStateOf(false)
            }

            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.LightGray,
                targetValue = Color.Gray,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1000
                        Color.Red at 500
                    },
                    repeatMode = RepeatMode.Reverse
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                if (!isLoading) Text(
                    text = "Here is something",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                )
                else Box(
                    modifier = Modifier
                        .height(40.dp)
                        .background(color)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Button(onClick = {
                    isLoading = !isLoading
                }) {
                    Text(text = if (isLoading) "Stop Refresh" else "Refresh")
                }
            }
        }
    }
}