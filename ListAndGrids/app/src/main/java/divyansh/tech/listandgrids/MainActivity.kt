package divyansh.tech.listandgrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
//            ShowTextList()
//            ShowLazyTextList()
            ShowLazyVerticalGrid()
        }
    }
}

@Composable
fun ShowTextList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                enabled = true, state = ScrollState(0)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        listOfText.forEach {
            Text(text = it)
        }
    }
}

@Composable
fun ShowLazyTextList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
//        for (string in listOfText) {
//            item {
//                Text(text = string, modifier = Modifier.padding(vertical = 10.dp))
//            }
//        }
        items(listOfText) { item ->
            Text(text = item)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowLazyVerticalGrid() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 100.dp),
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listOfImages) {item ->
            Image(
                painter = painterResource(id = item),
                contentDescription = ""
            )
        }
    }
}
