package divyansh.tech.states_and_buttons_and_edittexts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import divyansh.tech.states_and_buttons_and_edittexts.ui.theme.States_and_buttons_and_EditTextsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            States_and_buttons_and_EditTextsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val textFieldState = remember {
                        mutableStateOf("")
                    }
                    var snackbarState by remember {
                        mutableStateOf(false)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        OutlinedTextField(
                            value = textFieldState.value,
                            label = {
                                    Text(text = "Enter Something Here...")
                            },
                            onValueChange = {
                                textFieldState.value = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Button(
                            onClick = { snackbarState = !snackbarState },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Toggle Snackbar")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = textFieldState.value,
                            modifier = Modifier.align(Alignment.Start)
                        )

                        if (snackbarState) {
                            Snackbar {
                                Text(text = "Hello I am a Snackbar.")
                            }
                        }
                    }
                }
            }
        }
    }
}