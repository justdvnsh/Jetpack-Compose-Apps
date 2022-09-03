package divyansh.tech.ultimateguidetonavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import divyansh.tech.ultimateguidetonavigation.Screens.Favorites.FavoriteScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Home.HomeScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.HomeScreenItems
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.homeNavGraph
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.settingsNavGraph
import divyansh.tech.ultimateguidetonavigation.Screens.Settings.SettingsScreen
import divyansh.tech.ultimateguidetonavigation.Utils.BottomBar
import divyansh.tech.ultimateguidetonavigation.Utils.BottomNavItems
import divyansh.tech.ultimateguidetonavigation.ui.theme.UltimateGuideToNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController) }
            ) {
                NavigationComponent(navController = navController)
            }
        }
    }
}

@Composable
fun NavigationComponent(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = HomeScreenItems.HOME_NAV_GRAPH) {
        homeNavGraph(navController)
        composable(BottomNavItems.FAVORITES) {
            FavoriteScreen()
        }
        settingsNavGraph(navController)
    }
}