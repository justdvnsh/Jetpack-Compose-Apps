package divyansh.tech.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import divyansh.tech.constraintlayout.ui.theme.ConstraintLayoutTheme
import java.text.SimpleDateFormat
import java.util.*

val listOfItems = arrayListOf<Int>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..10) {
            listOfItems.add(R.drawable.dog)
        }
        setContent {
            LazyColumn(
                contentPadding = PaddingValues(20.dp)
            ) {
                items(listOfItems) { item ->
                    ListItem(
                        painter = painterResource(id = item),
                        name = "",
                        date = "",
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ListItem(
    painter: Painter,
    name: String,
    date: String,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                val constraintSet = ConstraintSet {
                    val dogIv = createRefFor("dogIv")
                    val nameTv = createRefFor("nameTv")
                    val dateTv = createRefFor("dateTv")

                    val bottomGuideline = createGuidelineFromBottom(0.4f)

                    val favorite = createRefFor("fav")
                    val share = createRefFor("share")

                    constrain(dogIv) {
                        top.linkTo(parent.top)
                        bottom.linkTo(bottomGuideline)
                        start.linkTo(parent.start)
                        height = Dimension.value(40.dp)
                        width = Dimension.value(40.dp)
                    }

                    constrain(nameTv) {
                        top.linkTo(dogIv.top)
                        start.linkTo(dogIv.end, margin = 10.dp)
                        bottom.linkTo(dateTv.top)
                    }

                    constrain(dateTv) {
                        top.linkTo(nameTv.bottom)
                        start.linkTo(dogIv.end, margin = 10.dp)
                        bottom.linkTo(bottomGuideline)
                    }

                    constrain(favorite) {
                        top.linkTo(bottomGuideline, margin = 10.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 20.dp)
                        end.linkTo(share.start)
                        height = Dimension.wrapContent
                        width = Dimension.value(24.dp)
                    }

                    constrain(share) {
                        top.linkTo(bottomGuideline, margin = 10.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(favorite.end)
                        end.linkTo(parent.end, margin = 20.dp)
                        height = Dimension.wrapContent
                        width = Dimension.value(24.dp)
                    }

                    createHorizontalChain(favorite, share, chainStyle = ChainStyle.Spread)
                }

                ConstraintLayout(constraintSet) {

                    val format = SimpleDateFormat("dd-MM-yyyy")
                    val time = format.format(Date().time)

                    Image(painter = painter, contentDescription = "", modifier = Modifier.clip(
                        RoundedCornerShape(50.dp)).layoutId("dogIv"))

                    Text(
                        text = "Here is Something",
                        modifier = Modifier.layoutId("nameTv")
                    )

                    Text(
                        text = "Created at : $time",
                        modifier = Modifier.layoutId("dateTv")
                    )

                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        "favorite",
                        modifier = Modifier.layoutId("fav")
                    )

                    Icon(
                        Icons.Outlined.Share,
                        "share",
                        modifier = Modifier.layoutId("share")
                    )
                }
            }
        }
    }
}