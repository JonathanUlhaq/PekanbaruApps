package com.belajar.pekanbaruapps.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.belajar.pekanbaruapps.R

// Set of Material typography styles to start with

val poppins = FontFamily(
    fonts = listOf(

        Font(
            R.font.poppins_medium,
            weight = FontWeight.Medium
        ),

        Font(
            R.font.poppins_bold,
            weight = FontWeight.Bold
        ),

        Font(
            R.font.poppins_regular,
            weight = FontWeight.Thin
        ),

        Font(
            R.font.poppins_semibold,
            weight = FontWeight.SemiBold
        )
    )
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold
    ),
    h3 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium
    ),
    body1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Thin
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