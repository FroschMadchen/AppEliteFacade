package com.example.elitefacade.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val LightGreyBackground = Color(0xAEEBEAEC)
val Pink80 = Color(0xFFEFB8C8)
val background = Color(0xBF839ABE)
val backgroundBtn = Color(0xFFF98727)
val backgroundBtn323 = Color(0xE9072A64)

val backgroundButtonCheck = Color(0x7737B409)

val gradient1 = Color(0xADF98727)
val gradient0 = Color(0x88072A64)

val backgroundBottomNav = Color(0xFFA8B5CA)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

    sealed class ThemeColors(
        val background:Color,
        val surface:Color,
        val primary:Color,
        val text:Color,
        val textTitle:Color,
        val gradient1:Color,
        val gradient0: Color
    ){
        object Day:ThemeColors(
            background = Color(0xAEEBEAEC),
            surface = Color(0x7737B409),
            primary =  Color(0xFFFFFFFF),
            text =  Color(0xE9072A64),
            textTitle = Color(0xFFF98727),
            gradient1 = Color(0xADF98727),
            gradient0 = Color(0x88072A64)
        )
        object Night:ThemeColors(
            background =  Color(0xE9072A64),
            surface = Color(0xC97B7CA5),
            primary = Color(0x619EA9C7),
            text =  Color(0xFFFFFFFF),
            textTitle = Color(0xFFF98727),
            gradient1 = Color(0xADF98727),
            gradient0 = Color(0x88072A64)
        )
    }

