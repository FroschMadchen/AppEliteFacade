package com.example.elitefacade.ui.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object SingIn : Screen("sing_in")
    object Registration : Screen("registration")
    object RegistrationGetCode : Screen("registration_get_code")
    object NavBarClient : Screen("nav_bar_client")
    object NavBarEmployee : Screen("nav_bar_employee")

}
