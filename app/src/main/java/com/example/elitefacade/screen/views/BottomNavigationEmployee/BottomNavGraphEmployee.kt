package com.example.elitefacade.screen.views.BottomNavigationEmployee

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elitefacade.screen.model.BottomNavItemEmployee
import com.example.elitefacade.screen.views.BottomNavigationEmployee.Chat.ChatEmployeeView
import com.example.elitefacade.screen.views.BottomNavigationEmployee.EditProject.EditProjectView
import com.example.elitefacade.screen.views.BottomNavigationEmployee.Profile.ProfileView
import com.example.elitefacade.screen.views.BottomNavigationEmployee.ViewingProject.ViewingProjectView

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