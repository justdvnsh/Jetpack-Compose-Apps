package divyansh.tech.ultimateguidetonavigation.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.HomeScreenItems

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    var clickedState by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            clickedState = 1
            navHostController.navigate("${HomeScreenItems.Detail.screen_route}/${clickedState}") {
                launchSingleTop = true
                restoreState = true
            }
        }) {
            Text(text = "Go to Detail Screen 1")
        }

        Button(onClick = {
            clickedState = 2
            navHostController.navigate("${HomeScreenItems.Detail.screen_route}/${clickedState}") {
                launchSingleTop = true
                restoreState = true
            }
        }) {
            Text(text = "Go to Detail Screen 2")
        }

        Button(onClick = {
            clickedState = 3
            navHostController.navigate("${HomeScreenItems.Detail.screen_route}/${clickedState}") {
                launchSingleTop = true
                restoreState = true
            }
        }) {
            Text(text = "Go to Detail Screen 3")
        }
    }
}