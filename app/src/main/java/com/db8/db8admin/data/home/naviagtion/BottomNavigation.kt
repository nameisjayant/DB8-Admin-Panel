package com.db8.db8admin.data.home.naviagtion


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.db8.db8admin.utils.NavigationScreen


@Composable
fun BottomNavigationItems(navController: NavController) {

    val items = listOf(
        NavigationScreen.UserManagement,
        NavigationScreen.PostApproval,
        NavigationScreen.KeywordApproval,
        NavigationScreen.Profile,
    )
    val currentRoute = remember { mutableStateOf(NavigationScreen.UserManagement.route) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoutes = navBackStackEntry?.destination?.route
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                onClick = {
                    navController.navigate(item.route) {
                        currentRoute.value = item.route
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = "",
                    )
                },
                selectedContentColor = Color.Blue,
                selected = currentRoute.value == item.route,
                unselectedContentColor = Color.Black,
               // label = { Text(text = item.title, fontSize = 10.sp) },
            )
        }
    }

}