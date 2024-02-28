package com.example.elitefacade.ui.screen.BottomNavigationEmployee

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elitefacade.ui.model.BottomNavItemEmployee
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.Chat.ChatEmployeeView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.EditProject.EditProjectView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.Profile.ProfileView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ViewingProject.ViewingProjectView

@Composable
fun BottomNavGraphEmployee(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomNavItemEmployee.Profile.route){
        composable( route = BottomNavItemEmployee.Profile.route){
            ProfileView()
        }
        composable(route= BottomNavItemEmployee.Chat.route){
            ChatEmployeeView()
        }
        composable(route= BottomNavItemEmployee.EditProjects.route){
            EditProjectView()
        }
        composable(route = BottomNavItemEmployee.ViewingProjects.route){
            ViewingProjectView()
        }
    }

}