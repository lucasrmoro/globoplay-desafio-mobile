package br.com.globoplay.presentation.streams.list.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.globoplay.presentation.navigation.AppRoutes
import br.com.globoplay.presentation.streams.list.presentation.screen.ListStreamsScreen

fun NavGraphBuilder.listStreamsNavGraph(navController: NavHostController) {
    composable(AppRoutes.ListStreams) {
        ListStreamsScreen(
            navController = navController,
            onNavigateToStreamDetails = {}
        )
    }
}