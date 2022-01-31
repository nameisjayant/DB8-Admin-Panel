package com.db8.db8admin.data.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.common.CommonHeader
import com.db8.db8admin.data.home.models.Users
import com.db8.db8admin.data.home.models.usersData
import com.db8.db8admin.ui.theme.customTypo


@ExperimentalMaterialApi
@Composable
fun UserManagementScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {
        item {
            CommonHeader(text = "User management")
        }
        items(usersData) { user ->
            UserEachRow(users = user)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun UserEachRow(users: Users) {
    val dialog = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Image(
                painter = painterResource(id = users.image), contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = users.username,
                style = customTypo.body1,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 5.dp)
            )
        }
        Row(
            modifier = Modifier.clickable {
                dialog.value = true
            }
        ) {
            Image(
                painter = painterResource(id = users.active_image), contentDescription = "",
                modifier = Modifier
                    .size(8.dp)
                    .align(CenterVertically)
            )
            Text(
                text = users.active_des,
                style = customTypo.body1,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 5.dp)
            )
        }
    }

    if (dialog.value) {

        AlertDialog(
            onDismissRequest = {
                dialog.value = false
            },
            title = {

            },
            text = {
                Column() {
                    Text(
                        text = "Do you want to Unblock this User",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    CommonButton(text = "Save") {
                        dialog.value = false
                    }
                }
            },
            confirmButton = {

            },
            dismissButton = {

            }
        )
    }
}