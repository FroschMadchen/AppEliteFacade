package com.example.elitefacade.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.elitefacade.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle( // Самый крупный текст (заголовки)
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        // lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle( // средний крупный текст(заголовки)
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle( // для маленьких заголовках
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle( //для мелкого/среднего текста
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle( //для мелкого/среднего текста
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    )
    ,
    labelSmall = TextStyle( //для мелкого текста
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle( // тонкий заголовок (средний)
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    ,
    headlineSmall = TextStyle( // тонкий заголовок нижней навигации
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)