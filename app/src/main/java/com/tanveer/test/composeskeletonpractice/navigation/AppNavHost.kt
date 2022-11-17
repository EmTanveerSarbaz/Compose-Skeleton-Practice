package com.tanveer.test.composeskeletonpractice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tanveer.test.composeskeletonpractice.ui.DashboardScreen
import com.tanveer.test.composeskeletonpractice.ui.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "splash"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("splash") {
            SplashScreen(
                onNavigateToFriends = { navController.navigate("dashboard") }
            )
        }

        composable("dashboard") {
            DashboardScreen()
        }
    }

}