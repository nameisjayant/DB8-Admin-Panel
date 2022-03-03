package com.db8.db8admin.data.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.db8.db8admin.R
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.common.CommonEditText
import com.db8.db8admin.common.CommonLoginButton
import com.db8.db8admin.common.CommonTextFields2
import com.db8.db8admin.data.home.HomeActivity
import com.db8.db8admin.data.ui.CommonViewModel
import com.db8.db8admin.ui.theme.loginColor
import com.db8.db8admin.utils.PreferenceStore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    private val viewmodel:CommonViewModel by viewModels()
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LoginScreen(this,viewmodel)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun LoginScreen(context: Activity,viewModel: CommonViewModel) {
    val isDialog = remember { mutableStateOf(false) }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
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
            if (
                !TextUtils.isEmpty(email.value) &&
                !TextUtils.isEmpty(password.value)
            ) {
                if (email.value.trim().equals("admin@gmail.com", true) && password.value.trim()
                        .equals("admin", true)
                ) {
                    viewModel.setPref(PreferenceStore.index,"1")
                    isDialog.value = true
                    Handler(Looper.myLooper()!!).postDelayed({
                        context.startActivity(Intent(context, HomeActivity::class.java))
                        isDialog.value = false
                    }, 3000)
                } else {
                    Toast.makeText(context, "Email & Password doesn't match!!", Toast.LENGTH_LONG)
                        .show()
                }
            } else {
                Toast.makeText(context, "please enter email and password", Toast.LENGTH_LONG).show()
            }
        }

    }


    if (isDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            },
            confirmButton = {},
            backgroundColor = Color.Transparent
        )
    }
}

