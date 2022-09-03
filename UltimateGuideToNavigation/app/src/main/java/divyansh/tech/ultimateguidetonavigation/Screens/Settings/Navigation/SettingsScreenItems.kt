package divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Detail.DetailScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Settings.Language.LanguageScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Settings.SettingsScreen
import divyansh.tech.ultimateguidetonavigation.Utils.BottomNavItems

sealed class SettingsScreenItems(
    val title: String,
    val screen_route: String
) {
    companion object {
        const val LANGUAGE = "Language"
        const val SETTINGS = "Settings"
        const val SETTINGS_SCREEN_NAV_GRAPH = "Settings_nav_graph"
    }

    object Settings: SettingsScreenItems(SETTINGS, SETTINGS)
    object Language: SettingsScreenItems(LANGUAGE, LANGUAGE)
}

fun NavGraphBuilder.settingsNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = SettingsScreenItems.Settings.screen_route,
        route = SettingsScreenItems.SETTINGS_SCREEN_NAV_GRAPH
    ) {
        composable(SettingsScreenItems.Settings.screen_route) {
            SettingsScreen(navHostController)
        }
        composable(SettingsScreenItems.Language.screen_route) {
            LanguageScreen(navHostController)
        }
    }
}