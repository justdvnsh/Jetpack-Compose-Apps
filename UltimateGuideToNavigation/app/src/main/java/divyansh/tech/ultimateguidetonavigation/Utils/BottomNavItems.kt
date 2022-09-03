package divyansh.tech.ultimateguidetonavigation.Utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.HomeScreenItems
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.SettingsScreenItems

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