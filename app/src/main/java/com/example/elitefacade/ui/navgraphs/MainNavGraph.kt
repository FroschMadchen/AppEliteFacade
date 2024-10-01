package com.example.elitefacade.ui.navgraphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ScreenNavBarEmployee
import com.example.elitefacade.ui.screen.BottomNavigtionClient.ScreenNavBarClient
import com.example.elitefacade.ui.screen.Registration.RegistrationScreen
import com.example.elitefacade.ui.screen.Login.ScreenTabLayout
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.SignUpUIEvent
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.SignUpViewModel
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.SingUpUIState
import com.example.elitefacade.ui.screen.SplashScreen.SplashScreen

/**
 * created by kristina dimitrieva on 27.05.2024  новая ветка для навигации
 */
fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController) {
        composable(Screen.Splash.route) {
            SplashScreen(onNavigateInHomeScreen={navController.navigate(Screen.SingIn.route)})
        }
        composable(Screen.SingIn.route) {
            ScreenTabLayout(onNavigateInBarClientScreen={navController.navigate(Screen.NavBarClient.route)},
                onNavigationInBarEmployeeScreen={navController.navigate(Screen.NavBarEmployee.route)}
            )
        }

        composable(Screen.NavBarClient.route) {
            ScreenNavBarClient(navController = navController)
        }
        composable(Screen.NavBarEmployee.route) {
            ScreenNavBarEmployee(navController)
        }
        composable(Screen.Registration.route) {
            val registrationViewModel = it.sharedViewModel<SignUpViewModel>(navController = navController)


            RegistrationScreen(
                onNavigateInMenuEmployee={navController.navigate(Screen.NavBarEmployee.route)},
                onUserNameChanged={email ->
                    registrationViewModel.onEvent(SignUpUIEvent.EmailChanged(email))},
                onjobTitleChanged={email ->
                    registrationViewModel.onEvent(SignUpUIEvent.EmailChanged(email))},
                onEmailChanged={email ->
                    registrationViewModel.onEvent(SignUpUIEvent.EmailChanged(email))},
                onPasswordChanged={email ->
                    registrationViewModel.onEvent(SignUpUIEvent.EmailChanged(email))},
                onPositionChanged ={email ->
                    registrationViewModel.onEvent(SignUpUIEvent.EmailChanged(email))},
                onRegisterButtonClicked={}

                )
        }
    }



@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}

/**
 * created by kristina dimitrieva on 21.05.2024  новая ветка для навигации
 */


/*@Composable
fun NavGraphBuilder(
    navController: NavHostController
) { // auth

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
}*/



