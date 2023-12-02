package br.com.globoplay.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.globoplay.presentation.streams.list.presentation.navigation.listStreamsNavGraph
import br.com.globoplay.presentation.newAndHot.presentation.navigation.newAndHotNavigation
import br.com.globoplay.presentation.profile.presentation.navigation.profileNavGraph

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoutes.ListStreams) {
        listStreamsNavGraph(navController = navController)
        newAndHotNavigation(navController = navController)
        profileNavGraph(navController = navController)
    }
}