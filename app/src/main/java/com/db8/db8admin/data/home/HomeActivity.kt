package com.db8.db8admin.data.home

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.db8.db8admin.data.home.naviagtion.BottomNavigationItems
import com.db8.db8admin.data.home.naviagtion.HomeNavigation
import com.db8.db8admin.data.ui.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewmodel:CommonViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                Surface {
                    HomeUiScreen(this,viewmodel)
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun HomeUiScreen(context:Activity,viewModel: CommonViewModel) {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationItems(navHostController) }
    ) {
        HomeNavigation(navHostController,context,viewModel)
    }

}