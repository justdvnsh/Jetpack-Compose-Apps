package divyansh.tech.listandgrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import divyansh.tech.listandgrids.ui.theme.ListAndGridsTheme

private val listOfText = arrayListOf<String>()
private val listOfImages = arrayListOf<Int>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..100) {
            listOfText.add("Text View $i")
        }
        for (i in 0..100) {
            listOfImages.add(R.drawable.dog)
        }
        setContent {

        }
    }
}