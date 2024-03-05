package com.example.elitefacade.ui.screen.BottomNavigationEmployee

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elitefacade.presentation.theme.EliteFacadeTheme
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.Chat.ChatEmployeeView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.EditProject.EditProjectView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.Profile.ProfileView
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ViewingProject.ViewingProjectView
import com.example.elitefacade.ui.screen.Screen

@Composable
fun BottomNavGraphEmployee(navController: NavHostController, navControllerMain: NavController){
    EliteFacadeTheme(darkTheme = false) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItemEmployee.Profile.route
        ) {

            composable(route = BottomNavItemEmployee.Chat.route) {
                ChatEmployeeView()
            }
            composable(route = BottomNavItemEmployee.EditProjects.route) {
                EditProjectView()
            }
            composable(route = BottomNavItemEmployee.ViewingProjects.route) {
                ViewingProjectView()
            }
            composable(route = BottomNavItemEmployee.Profile.route) {
                ProfileView(navControllerMain)
            }

        }
    }
}