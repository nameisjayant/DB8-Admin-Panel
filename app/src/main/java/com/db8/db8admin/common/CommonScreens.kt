package com.db8.db8admin.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonLoginButton(
    title: String,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        Arrangement.Center
    ) {
        OutlinedButton(
            onClick = { onClick() },
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = color
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 5.dp, bottom = 5.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Composable
fun CommonTextFields2(
    title: MutableState<String>,
    label: String?,
    keyboardType: KeyboardType?,
    placeholder: String?,
    leadingIcon: ImageVector?,
) {

    OutlinedTextField(
        value = title.value,
        label = { Text(text = label!!) },
        onValueChange = { title.value = it },
        placeholder = { Text(text = placeholder!!) },
        modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType!!),
        shape = RoundedCornerShape(10.dp),
        leadingIcon = { Icon(leadingIcon!!, contentDescription = "") },
    )

}


@Composable
fun CommonHeader(text: String) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        ) {
        Box(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "")
                }
                Text(
                    text = text, fontWeight = FontWeight.W800, fontSize = 17.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Column {

                }
            }
        }
    }

}