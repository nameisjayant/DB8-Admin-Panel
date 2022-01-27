package com.db8.db8admin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.db8.db8admin.R

// Set of Material typography styles to start with

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val font = FontFamily(
    Font(R.font.poppins_regular)
)
val font_bold = FontFamily(Font(R.font.poppins_bold))

val customTypo = Typography(

    body1 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

    h1 = TextStyle(
        fontFamily = font_bold,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),
)