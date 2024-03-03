package com.example.elitefacade.ui.navgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ScreenNavBarEmployee
import com.example.elitefacade.ui.screen.BottomNavigtionClient.ScreenNavBarClient
import com.example.elitefacade.ui.screen.Registration.RegistrationGetCode
import com.example.elitefacade.ui.screen.Registration.RegistrationGetCodeScreen
import com.example.elitefacade.ui.screen.Registration.RegistrationScreen
import com.example.elitefacade.ui.screen.Screen
import com.example.elitefacade.ui.screen.SingIn.ScreenTabLayout
import com.example.elitefacade.ui.screen.SplashScreen.SplashScreen

@Composable
fun MainNavGraph() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.SingIn.route) {
            ScreenTabLayout(navController = navController)
        }

        composable(Screen.NavBarClient.route) {
            ScreenNavBarClient(navController = navController)
        }
        composable(Screen.NavBarEmployee.route) {
            ScreenNavBarEmployee(navController)

        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController)
        }


    }
}


