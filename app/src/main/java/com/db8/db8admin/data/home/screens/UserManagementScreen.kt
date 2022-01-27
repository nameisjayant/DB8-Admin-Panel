package com.db8.db8admin.data.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.db8.db8admin.common.CommonHeader
import com.db8.db8admin.data.home.models.Users
import com.db8.db8admin.data.home.models.usersData
import com.db8.db8admin.ui.theme.customTypo


@Composable
fun UserManagementScreen() {

    LazyColumn {
        item {
            CommonHeader(text = "User management")
        }
        items(usersData) { user ->
            UserEachRow(users = user)
        }
    }
}

@Composable
fun UserEachRow(users: Users) {

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
        Row() {
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
}