package com.db8.db8admin.data.home

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.db8.db8admin.data.home.naviagtion.BottomNavigationItems
import com.db8.db8admin.data.home.naviagtion.HomeNavigation

class HomeActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                Surface {
                    HomeUiScreen(this)
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun HomeUiScreen(context:Activity) {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationItems(navHostController) }
    ) {
        HomeNavigation(navHostController,context)
    }

}