package com.db8.db8admin.data.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.db8.db8admin.R
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.common.CommonEditText
import com.db8.db8admin.common.CommonLoginButton
import com.db8.db8admin.common.CommonTextFields2
import com.db8.db8admin.data.home.HomeActivity
import com.db8.db8admin.ui.theme.loginColor

class LoginActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LoginScreen(this)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun LoginScreen(contex: Activity) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(start = 20.dp,end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column() {
            Image(
                painter = painterResource(id = R.drawable.db8_logo),
                contentDescription = "",
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
            )
        }

        CommonEditText(
            label = "Email",
            placeholder = "Enter Email",
            leadingIcon = Icons.Default.Email,
            text = email
        )
        CommonEditText(
            label = "Password",
            placeholder = "Enter Password",
            leadingIcon = Icons.Default.Lock,
            text = password
        )

        CommonButton("Login") {
            contex.startActivity(Intent(contex, HomeActivity::class.java))
        }

    }

}
