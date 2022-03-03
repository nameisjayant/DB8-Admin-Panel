package com.db8.db8admin.data.start

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.db8.db8admin.R
import com.db8.db8admin.data.home.HomeActivity
import com.db8.db8admin.data.login.LoginActivity
import com.db8.db8admin.data.ui.CommonViewModel
import com.db8.db8admin.ui.theme.DB8AdminTheme
import com.db8.db8admin.utils.PreferenceStore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    private val viewmodel: CommonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DB8AdminTheme {

                Surface(color = MaterialTheme.colors.background) {
                    SplashScreen(context = this, viewmodel)
                }
            }
        }
    }
}


@Composable
fun SplashScreen(
    context: Activity,
    viewModel: CommonViewModel
) {
    val scope = rememberCoroutineScope()

    val scale = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(durationMillis = 800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        delay(3000L)

        scope.launch(Dispatchers.Main) {
            viewModel.getPref(PreferenceStore.index).collect {
                when (it) {
                    "1" -> {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                        context.finish()
                    }
                    else -> {
                        context.startActivity(Intent(context, LoginActivity::class.java))
                        context.finish()
                    }
                }
            }


            context.startActivity(Intent(context, LoginActivity::class.java))

        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.db8_logo), contentDescription = "notepad",
            modifier = Modifier
                .scale(scale.value)
                .height(150.dp)
                .width(150.dp)
        )
        Text(text = "Discuss Debate and Share Your Opinions", color = Color.DarkGray)
    }

}


