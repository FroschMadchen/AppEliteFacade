package com.example.elitefacade.screen.views.BottomNavigtionClient

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elitefacade.screen.model.BottomNavItem
import com.example.elitefacade.screen.views.BottomNavigtionClient.Chat.ChatView
import com.example.elitefacade.screen.views.BottomNavigtionClient.Order.OrderClientPrevView

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Order.route
    ){
        composable(route = BottomNavItem.Order.route){
            OrderClientPrevView(navController)
        }
        composable(route = BottomNavItem.Chat.route){
            ChatView()
        }
       /* composable("ScreenSingIn"){

        }*/
    }
}