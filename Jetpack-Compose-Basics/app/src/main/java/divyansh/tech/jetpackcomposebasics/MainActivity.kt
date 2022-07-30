package divyansh.tech.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import divyansh.tech.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.logo)
            Box(modifier = Modifier.padding(20.dp)) {
                Column {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 30.sp
                            )) {
                                append("L")
                            }
                            append("atest")
                        },
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageCard(image = painter, text = "Anime Classroom")
                        ImageCard(image = painter, text = "Anime Classroom")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 30.sp
                            )) {
                                append("T")
                            }
                            append("rending")
                        },
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageCard(image = painter, text = "Anime Classroom")
                        ImageCard(image = painter, text = "Anime Classroom")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
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
        Box(
            modifier = Modifier.fillMaxSize()
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
}