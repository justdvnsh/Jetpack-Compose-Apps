package divyansh.tech.ultimateguidetonavigation.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import divyansh.tech.ultimateguidetonavigation.settings.SettingsScreen
import divyansh.tech.ultimateguidetonavigation.settings.language.LanguageScreen

sealed class SettingsScreenItems(
    val title: String,
    val screen_route: String
) {
    companion object {
        const val LANGUAGE = "Language"
        const val SETTINGS = "SETTINGS"
        const val SETTINGS_SCREEN_NAV_GRAPH = "Settings_nav_graph"
    }

    object Settings: SettingsScreenItems(SETTINGS, SETTINGS)
    object Language: SettingsScreenItems(LANGUAGE, LANGUAGE)
}

fun NavGraphBuilder.settingsNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = SettingsScreenItems.SETTINGS,
        route = SettingsScreenItems.SETTINGS_SCREEN_NAV_GRAPH
    ) {
        composable(SettingsScreenItems.SETTINGS) {
            SettingsScreen(navHostController)
        }
        composable(SettingsScreenItems.LANGUAGE) {
            LanguageScreen(navHostController)
        }
    }
}