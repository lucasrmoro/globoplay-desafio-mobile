package br.com.globoplay.presentation.profile.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.globoplay.presentation.navigation.AppRoutes
import br.com.globoplay.presentation.profile.presentation.screen.ProfileScreen

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    composable(AppRoutes.Profile) {
        ProfileScreen(
            navController = navController
        )
    }
}