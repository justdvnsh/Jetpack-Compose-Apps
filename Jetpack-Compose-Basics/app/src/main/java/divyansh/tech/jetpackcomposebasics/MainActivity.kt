package divyansh.tech.jetpackcomposebasics

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(
                            color = Color.Red,
                            fontSize = 30.sp
                        )) {
                            append("L")
                        }
                        append("atest")
                    },
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ImageCard(
                        image = painterResource(id = R.drawable.dog),
                        text = "Jetpack Compose"
                    )

                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                    ImageCard(
                        image = painterResource(id = R.drawable.dog),
                        text = "Jetpack Compose"
                    )
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    image: Painter,
    text: String
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        backgroundColor = Color.Blue
    ) {
        Image(
            painter = image, contentDescription = text,
            modifier = Modifier
                .height(200.dp)
                .width(150.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart,
        ) {
            Text(text = text, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}
