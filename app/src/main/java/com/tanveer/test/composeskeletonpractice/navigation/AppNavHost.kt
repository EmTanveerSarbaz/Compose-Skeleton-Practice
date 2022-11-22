package com.tanveer.test.composeskeletonpractice.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.presentation.DashboardScreen
import com.tanveer.test.composeskeletonpractice.screens_pre_login.screen_splash.presentation.SplashScreen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,

    startDestination: String = "splash"
) {
    //region For Drawer purpose
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    //endregion
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = {
            TopBar(
                navController = navController,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },


        drawerContent = {
            DrawerHeader()
            DrawerBody(navController = navController, closeNavDrawer = {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        },

        bottomBar = {
            BottomBarNav(navController = navController)
        }


    )
    {
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

}