package com.example.elitefacade.ui.screen.SplashScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.elitefacade.R
import com.example.elitefacade.ui.navgraphs.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    onNavigateInHomeScreen:() -> Unit = {}){

    LaunchedEffect(key1 = true){
        delay(100)//3000
        onNavigateInHomeScreen()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        LoaderAnimetion(
            modifier= Modifier.size(400.dp),
            anim = R.raw.animation_2
        )

    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun LoaderAnimetion(modifier: Modifier, anim:Int){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier)
}