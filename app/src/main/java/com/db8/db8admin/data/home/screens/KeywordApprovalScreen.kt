package com.db8.db8admin.data.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.db8.db8admin.common.CommonHeader
import com.db8.db8admin.data.home.models.Keywords
import com.db8.db8admin.data.home.models.keywordList
import com.db8.db8admin.ui.theme.customTypo


@Composable
fun KeywordApprovalScreen() {

    LazyColumn {
        item {
            CommonHeader(text = "Keyword Approval")
        }
        items(keywordList) { keyword ->
            KeywordEachRow(keywords = keyword)
        }
    }

}

@Composable
fun KeywordEachRow(keywords: Keywords) {
    val expanded = remember { mutableStateOf(false) }
    val approveList = remember { mutableStateOf(listOf("Block", "UnBlock")) }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp
    ) {
        Box(modifier = Modifier.background(Color(0xFFF6F1FF))) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = keywords.postImage), contentDescription = "",
                        modifier = Modifier
                            .width(116.dp)
                            .height(102.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                        ) {
                            Image(
                                painter = painterResource(id = keywords.userImage),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = keywords.username,
                                style = customTypo.body1,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 5.dp)
                            )
                        }
                        Row() {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "",
                                tint = Color(0XFF3900B3),
                                modifier = Modifier.clickable {
                                    expanded.value = !expanded.value
                                }
                            )

                            DropdownMenu(
                                expanded = expanded.value,
                                onDismissRequest = { expanded.value = false },
                                modifier = Modifier
                                    .width(100.dp)
//                modifier = Modifier.width(with(LocalDensity.current) {
//                    textFieldSize.value.width.toDp()
//                })
                            ) {
                                approveList.value.forEach { label ->
                                    DropdownMenuItem(onClick = {
                                        expanded.value = false
                                    }) {
                                        Text(text = label)
                                    }
                                }
                            }
                        }
                    }

                    Row() {
                        Text(
                            text = keywords.postDescription,
                            style = customTypo.body2,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(5.dp)
                        )
                    }

                    Row() {
                        Image(
                            painter = painterResource(id = keywords.approveImage),
                            contentDescription = "",
                            modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = keywords.approve,
                            style = customTypo.body1,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 5.dp),
                            color = if (keywords.approve == "Approved") Color(0XFF00C000) else Color.Red
                        )
                    }
                }
            }

        }
    }

}
