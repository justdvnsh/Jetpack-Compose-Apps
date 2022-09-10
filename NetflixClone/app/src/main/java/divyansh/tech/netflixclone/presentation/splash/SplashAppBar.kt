package divyansh.tech.netflixclone.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import divyansh.tech.netflixclone.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SplashAppBar(
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row {
                Image(
                    painter = painterResource(R.drawable.netflix_logo),
                    contentDescription = null
                )
            }
        },
        backgroundColor = backgroundColor,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Surface(
                    onClick = {  }
                ) {
                    Text(text = "PRIVACY", fontWeight = FontWeight.ExtraBold)
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = ""
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ShowAppBar() {
    SplashAppBar(backgroundColor = Color.Transparent)
}