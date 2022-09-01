package divyansh.tech.materialcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import divyansh.tech.materialcomponents.ui.theme.MaterialComponentsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar() {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Divyansh", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.ExtraBold)
                            IconButton(
                                modifier = Modifier.padding(16.dp),
                                onClick = { /* todo */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Settings,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                },
                bottomBar = {
                    BottomAppBar() {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                },
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Icon(Icons.Outlined.Menu, "")
                            }
                            IconButton(
                                modifier = Modifier.padding(16.dp),
                                onClick = { /* todo */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Settings,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Add, "", modifier = Modifier.padding(16.dp))
                    }
                },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true,
                drawerContent = {
                    Text(
                        text = "Divyansh",
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(16.dp)
                    )

                    Text(
                        text = "Divyansh",
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(16.dp)
                    )

                    Text(
                        text = "Divyansh",
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(12.dp)
                    ) {
                        Icon(
                            Icons.Outlined.Favorite,
                            "Fav"
                        )

                        Text(text = "Like", modifier = Modifier.padding(horizontal = 10.dp))
                    }

                    Spacer(modifier = Modifier.padding(vertical = 12.dp))

                    ExtendedFloatingActionButton(
                        text = { Text(text = "Like")},
                        onClick = { /*TODO*/ },
                        icon = { Icon(Icons.Outlined.Favorite, "") }
                    )
                }
            }
        }
    }
}