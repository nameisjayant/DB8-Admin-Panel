package com.db8.db8admin.data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.db8.db8admin.common.CommonButton
import com.db8.db8admin.ui.theme.DB8AdminTheme

class ReportActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DB8AdminTheme() {
                Surface {
                    ReportDetails()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ReportDetails() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
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

        Column(modifier = Modifier.padding(25.dp)) {
            Text(
                text = "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain.",

                )
        }
        Column() {
            CommonButton(text = "Block User") {

            }
            CommonButton(text = "UnBlock User") {

            }
            CommonButton(text = "Block/Remove Post") {

            }
        }
    }
}