package divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Detail.DetailScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Home.HomeScreen
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.HomeScreenItems.Companion.HOME
import divyansh.tech.ultimateguidetonavigation.Screens.Home.Navigation.HomeScreenItems.Companion.HOME_NAV_GRAPH
import divyansh.tech.ultimateguidetonavigation.Utils.BottomNavItems

sealed class HomeScreenItems(
    val title: String,
    val screen_route: String
) {
    companion object {
        const val DETAIL = "Details"
        const val HOME = "Home"
        const val HOME_NAV_GRAPH = "HOME_NAV_GRAPH"
    }

    object Home: HomeScreenItems(HOME, HOME)
    object Detail: HomeScreenItems(DETAIL, DETAIL) {
        const val ARGUMENT_NAME = "arg_id"
        val arguments = listOf(
            navArgument(ARGUMENT_NAME) { type = NavType.IntType }
        )
        val deepLinks = listOf(
            navDeepLink {
                uriPattern = "myapp://${Detail.screen_route}/{${ARGUMENT_NAME}}"
            }
        )
    }
}

fun NavGraphBuilder.homeNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = HomeScreenItems.Home.screen_route,
        route = HomeScreenItems.HOME_NAV_GRAPH
    ) {
        composable(HomeScreenItems.Home.screen_route) {
            HomeScreen(navHostController)
        }
        composable(
            route = "${HomeScreenItems.Detail.screen_route}/{${HomeScreenItems.Detail.ARGUMENT_NAME}}",
            arguments = HomeScreenItems.Detail.arguments,
            deepLinks = HomeScreenItems.Detail.deepLinks
        ) {
            val id = it.arguments?.getInt(HomeScreenItems.Detail.ARGUMENT_NAME)
            DetailScreen(navHostController, id)
        }
    }
}