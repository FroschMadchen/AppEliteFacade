package com.example.elitefacade.ui.screen.BottomNavigtionClient

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elitefacade.ui.model.BottomNavItemClinet
import com.example.elitefacade.ui.screen.BottomNavigtionClient.Chat.ChatView
import com.example.elitefacade.ui.screen.BottomNavigtionClient.Order.OrderClientPrevView

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItemClinet.Order.route
    ) {
        composable(route = BottomNavItemClinet.Order.route) {
            OrderClientPrevView(navController)
        }
        composable(route = BottomNavItemClinet.Chat.route) {
            ChatView()
        }
    }
}