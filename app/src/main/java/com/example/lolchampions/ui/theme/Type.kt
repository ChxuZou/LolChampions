package com.example.lolchampions.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lolchampions.R

val Beaufortfor = FontFamily(
    Font(R.font.beaufortfor_lol_regular)
)
val Spiegel = FontFamily(
    Font(R.font.spiegel_tt_bold)
)

val gradientGold = Brush.horizontalGradient(listOf(Color(0xFFC89B3C),Color(0xFF785A28)))
val goldToWhite = Brush.verticalGradient(listOf(Color(0xFFBBBBBB),Color(0xFFC89B3C)))
val greyBrush = Brush.horizontalGradient(listOf(Color(0xFFA18594), Color(0xFFA18594)))


@OptIn(ExperimentalTextApi::class)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Beaufortfor,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        brush = goldToWhite
    ),
    displayMedium = TextStyle(
        fontFamily = Beaufortfor,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        brush = gradientGold
    ),
    labelSmall = TextStyle(
        fontFamily = Beaufortfor,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        brush = gradientGold,
    ),
    bodyLarge = TextStyle(
        fontFamily = Spiegel,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        brush = greyBrush

    )
)


