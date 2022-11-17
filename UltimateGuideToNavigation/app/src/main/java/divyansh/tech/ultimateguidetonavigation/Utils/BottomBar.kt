package divyansh.tech.ultimateguidetonavigation.Utils

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import divyansh.tech.ultimateguidetonavigation.home.navigation.HomeScreenItems
import divyansh.tech.ultimateguidetonavigation.settings.navigation.SettingsScreenItems

sealed class BottomNavItems(
    var title: String,
    var icon: ImageVector,
    var screen_route: String
) {

    companion object {
        const val HOME = "Home"
        const val FAVORITES = "Favorites"
        const val SETTINGS = "Settings"
    }

    object Home: BottomNavItems(HOME, Icons.Outlined.Home, HomeScreenItems.Home.screen_route)
    object Favorites: BottomNavItems(FAVORITES, Icons.Outlined.Favorite, FAVORITES)
    object Settings: BottomNavItems(SETTINGS, Icons.Outlined.Settings, SettingsScreenItems.Settings.screen_route)

}

@Composable
fun BottomBar(
    navHostController: NavHostController
) {
    val items = listOf<BottomNavItems>(
        BottomNavItems.Home,
        BottomNavItems.Favorites,
        BottomNavItems.Settings
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.primary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = ""
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.secondary,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navHostController.navigate(item.screen_route) {
                        navHostController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}