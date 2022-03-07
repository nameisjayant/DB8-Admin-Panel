package com.db8.db8admin.data.home.naviagtion

import android.app.Activity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.db8.db8admin.data.home.screens.KeywordApprovalScreen
import com.db8.db8admin.data.home.screens.PostApprovalScreen
import com.db8.db8admin.data.home.screens.ProfileScreen
import com.db8.db8admin.data.home.screens.UserManagementScreen
import com.db8.db8admin.data.ui.CommonViewModel
import com.db8.db8admin.utils.NavigationScreen


@ExperimentalMaterialApi
@Composable
fun HomeNavigation(
    navController: NavHostController,
    context: Activity,
    viewmodel: CommonViewModel
) {


    NavHost(
        navController = navController,
        startDestination = NavigationScreen.UserManagement.route
    ) {
        composable(NavigationScreen.UserManagement.route) {
            UserManagementScreen(context)
        }
        composable(NavigationScreen.PostApproval.route) {
            PostApprovalScreen(viewmodel)
        }
        composable(NavigationScreen.KeywordApproval.route) {
            KeywordApprovalScreen(viewmodel,navController)
        }
        composable(NavigationScreen.Profile.route) {
            ProfileScreen()
        }
    }

}