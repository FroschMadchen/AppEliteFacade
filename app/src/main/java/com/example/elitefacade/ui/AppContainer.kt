package com.example.elitefacade.ui

import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.elitefacade.ui.navgraphs.Screen
import com.example.elitefacade.ui.navgraphs.mainNavGraph


/**
 * created by kristina on 27.05.2024
 */
@Composable
fun AppContainer() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        mainNavGraph(
            navController = navController,
        )
    }
}