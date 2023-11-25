package br.com.globoplay.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.globoplay.presentation.streams.list.presentation.navigation.listStreamsNavGraph

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoutes.ListStreams) {
        listStreamsNavGraph(navController = navController)
    }
}