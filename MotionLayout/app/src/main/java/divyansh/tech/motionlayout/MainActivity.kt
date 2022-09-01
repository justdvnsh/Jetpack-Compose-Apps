package divyansh.tech.motionlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*
import divyansh.tech.motionlayout.ui.theme.MotionLayoutTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMotionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var progressValue by remember {
                mutableStateOf(0f)
            }
            val animatedProgress by animateFloatAsState(
                targetValue = progressValue,
                animationSpec = keyframes {
                    durationMillis = 1000
                    0.5f at 500
                }
            )
            val constraintSetStart = ConstraintSet {
                val videoView = createRefFor("videoView")
                val titleTv = createRefFor("titleTv")

                val topGuideline = createGuidelineFromTop(0.3f)

                constrain(videoView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(topGuideline)
                    height = Dimension.fillToConstraints
                    width = Dimension.matchParent
                }

                constrain(titleTv) {
                    top.linkTo(topGuideline, margin = 12.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                    end.linkTo(parent.end)
                    height = Dimension.wrapContent
                    width = Dimension.matchParent
                }
            }

            val constraintSetEnd = ConstraintSet {
                val videoView = createRefFor("videoView")
                val titleTv = createRefFor("titleTv")

                val bottomGuideline = createGuidelineFromBottom(0.1f)

                constrain(videoView) {
                    top.linkTo(bottomGuideline)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.value(150.dp)
                }

                constrain(titleTv) {
                    top.linkTo(bottomGuideline, margin = 2.dp)
                    start.linkTo(videoView.end, margin = 6.dp)
                    end.linkTo(parent.end)
                    height = Dimension.wrapContent
                    width = Dimension.fillToConstraints
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                MotionLayout(
                    start = constraintSetStart,
                    end = constraintSetEnd,
                    progress = animatedProgress,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier
                        .background(Color.Black)
                        .layoutId("videoView"))
                    Text(
                        text = "Motion Layout with Jetpack Compose",
                        modifier = Modifier.layoutId("titleTv"),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Slider(
                    value = progressValue,
                    onValueChange = {
                        progressValue = it
                    },
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}
