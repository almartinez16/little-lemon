package com.example.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

// Little Lemon fonts
val MarkaziText = FontFamily(Font(R.font.markazitext_regular))
val Karla = FontFamily(Font(R.font.karla_regular))

val LittleLemon = Typography(
    // Display Title
    h1 =  TextStyle(
        fontFamily = MarkaziText,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp
    ),
    // Sub Title
    subtitle1 = TextStyle(
        fontFamily = MarkaziText,
        fontSize = 40.sp
    ),
    // Regular
    h2 = TextStyle(
        fontFamily = MarkaziText,
        fontSize = 40.sp
    ),
    // Section Title
    h3 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    // Lead Text
    h4 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    // Categories
    h5 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    // Paragraph text Max 65 lines per line
    body2 = TextStyle(
        fontFamily = Karla,
        fontSize = 16.sp,
        lineHeight = 15.sp,

    ),
    // Highlight text
    caption = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

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