package br.com.globoplay.presentation.newAndHot.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.globoplay.presentation.navigation.AppRoutes
import br.com.globoplay.presentation.newAndHot.presentation.screen.NewAndHotScreen


fun NavGraphBuilder.newAndHotNavigation(navController: NavHostController) {
    composable(AppRoutes.NewAndHot) {
        NewAndHotScreen(
            navController = navController
        )
    }
}