package com.tanveer.test.composeskeletonpractice.navigation

import android.widget.Toast
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tanveer.test.composeskeletonpractice.R

@Composable
fun BottomBarNav(
    navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current
    if (currentRoute == null || currentRoute == "login") {
        return
    }

    BottomNavigation {
        val homeSelected = currentRoute == "splash"
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "splash"
                )
            },
            selected = homeSelected,
            onClick = {
                if(!homeSelected) {
                    navController.navigate("splash") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
                Toast.makeText(context, "Navigated to Dashboard Screen via BottomNav Event", Toast.LENGTH_SHORT).show()

            },
            label = {
                if(homeSelected){
                    Text(
                        color = Color.Companion.White,
                        text = "Splash"
                    )
                }
                else{
                    Text(
                        color = Color.Companion.Gray,
                        text = "Splash"
                    )
                }

            }
        )

        val searchSelected =  currentRoute == "dashboard"
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "dashboard"
                )
            },
            selected = searchSelected,
            onClick = {
                if(!searchSelected) {
                    navController.navigate("dashboard")
                }

                Toast.makeText(context, "Navigated to Search Screen via BottomNav Event", Toast.LENGTH_SHORT).show()

            },
            label = {
                if(searchSelected){
                    Text(
                        color = Color.Companion.White,
                        text = "Dashboard"
                    )
                }
                else{
                    Text(
                        color = Color.Companion.Gray,
                        text = "Dashboard"
                    )
                }
            }
        )
    }
}