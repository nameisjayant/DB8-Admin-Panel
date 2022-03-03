package com.db8.db8admin.data.home.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.common.CommonEditText
import com.db8.db8admin.common.CommonHeader
import com.db8.db8admin.data.ReportActivity
import com.db8.db8admin.data.home.models.Report
import com.db8.db8admin.data.home.models.Users
import com.db8.db8admin.data.home.models.reportList
import com.db8.db8admin.data.home.models.usersData
import com.db8.db8admin.ui.theme.customTypo

@ExperimentalMaterialApi
@Composable
fun UserManagementScreen(context: Activity) {
    val search = remember { mutableStateOf("") }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {
        item {
            CommonHeader(text = "Reported User")
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                CommonEditText(
                    label = "User ID",
                    placeholder = "Search User ID",
                    leadingIcon = Icons.Default.Search,
                    text = search
                )
            }
        }
        items(reportList) { report ->
            ReportEachRow(report, context)
        }
    }
}


@Composable
fun ReportEachRow(report: Report, context: Activity) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp
    ) {
        Box(modifier = Modifier.background(Color(0xFFF6F1FF))) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    //shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp
                ) {
                    Box(modifier = Modifier.background(Color.Black)) {

                        Column() {
                            Text(
                                text = "02 February 2022, 12:09 PM",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Reported User Details",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "User ID: ${report.reportedUserId}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "User Name: ${report.reportedUsername}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Reporting User Details",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "User ID: ${report.reportingUserId}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "User Name: ${report.reportingUsername}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Blocked Content",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 2.dp
                    ) {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .clickable {
                                context.startActivity(Intent(context, ReportActivity::class.java))
                            }) {
                            Text(
                                text = "ID : ${report.blockedId}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(10.dp)
                            )
                        }
                    }
                }


            }
        }

    }
}