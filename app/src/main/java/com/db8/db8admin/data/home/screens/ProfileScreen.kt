package com.db8.db8admin.data.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.common.CommonEditText
import com.db8.db8admin.common.CommonHeader
import com.db8.db8admin.ui.theme.customTypo


@ExperimentalMaterialApi
@Composable
fun ProfileScreen() {

    val oldPassword = remember { mutableStateOf("") }
    val newPassword = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        CommonHeader(text = "Profile")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            CommonEditText(
                label = "Old Password",
                placeholder = "Enter old Password",
                leadingIcon = Icons.Default.Lock,
                text = oldPassword
            )
            CommonEditText(
                label = "New Password",
                placeholder = "Enter New Password",
                leadingIcon = Icons.Default.Lock,
                text = newPassword
            )
            CommonEditText(
                label = "Confirm Password",
                placeholder = "Confirm Password",
                leadingIcon = Icons.Default.Lock,
                text = confirmPassword
            )

            CommonButton(text = "Done") {

            }
        }
    }
}