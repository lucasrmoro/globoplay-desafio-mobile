package br.com.globoplay.presentation.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.globoplay.core.providers.DimensProvider
import br.com.globoplay.presentation.navigation.BottomNavItem

@Composable
fun CommonBottomBar(navController: NavController) {
    val items = BottomNavItem.values()
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                alwaysShowLabel = true,
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        fontSize = DimensProvider.SMALLEST_TEXT
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(DimensProvider.MEDIUM_DIMEN),
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                }
            )
        }
    }
}