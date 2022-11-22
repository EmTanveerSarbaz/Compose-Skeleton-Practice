package com.tanveer.test.composeskeletonpractice.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tanveer.test.composeskeletonpractice.R.*

@Composable
fun DrawerHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(navController: NavHostController?, closeNavDrawer: () -> Unit) {
    Column {
        DefaultDrawerNavigationItemsWithSelectionEnabled(navController, closeNavDrawer)
    }
}

@Composable
private fun CustomDrawerNavigationItems(
    navController: NavHostController?,
    closeNavDrawer: () -> Unit
) {
    //The problem with the custom drawer item was the selection of the current clicked drawer option,
    //which was implemented in 'NavigationDrawerItem', for such UX i.e. keep the selection of the item of drawer
    //we needed to code for that part too.
    val navBackStackEntry by navController?.currentBackStackEntryAsState()!!
    val currentRoute = navBackStackEntry?.destination?.route
    DrawerMenuItem(
        painter = painterResource(id = drawable.ic_home),
        text = "Splash",
        onItemClick = {
            navController?.navigate("splash") {
                //Helps in the backstack clearing when navigating
                //from one screen to other, means no screen will
                //stack when routing from drawer screen by below code.
                launchSingleTop = true
                popUpTo("splash") {
                    saveState = true
                }
            }

            closeNavDrawer()
        }
    )
    DrawerMenuItem(
        painter = painterResource(id = drawable.ic_search),
        text = "Dashboard",
        onItemClick = {
            navController?.navigate("dashboard") {
                launchSingleTop = true
                popUpTo("dashboard") {
                    saveState = true
                }
            }
            closeNavDrawer()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultDrawerNavigationItemsWithSelectionEnabled(
    navController: NavHostController?,
    closeNavDrawer: () -> Unit
) {
    val navBackStackEntry by navController?.currentBackStackEntryAsState()!!
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationDrawerItem(
        icon = {
            Icon(
                painter = painterResource(id = drawable.ic_home),
                contentDescription = "splash"
            )
        },
        label = { Text(text = "Splash") },
        selected = currentRoute == "splash",
        onClick = {
            navController?.navigate("splash") {
                //Helps in the backstack clearing when navigating
                //from one screen to other, means no screen will
                //stack when routing from drawer screen by below code.
                launchSingleTop = true
                popUpTo("splash") {
                    saveState = true
                }
            }
            closeNavDrawer()
        }
    )

    NavigationDrawerItem(
        icon = {
            Icon(
                painter = painterResource(id = drawable.ic_search),
                contentDescription = "dashboard"
            )
        },
        label = { Text(text = "Dashboard") },
        selected = currentRoute == "dashboard",
        onClick = {
            navController?.navigate("dashboard") {
                launchSingleTop = true
                popUpTo("dashboard") {
                    saveState = true
                }
            }
            closeNavDrawer()
        }
    )
}

@Composable
fun DrawerMenuItem(
//    imageVector: ImageVector,
    painter: Painter,
    text: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painter, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }

}

@Preview(showBackground = true)
@Composable
fun DrawerHeaderPreview() {
    DrawerHeader()
}

@Preview(showBackground = true)
@Composable
fun DrawerBodyPreview() {
    DrawerBody(
        navController = null,
        closeNavDrawer = {}
    )
}
