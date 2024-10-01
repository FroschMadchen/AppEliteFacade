package com.example.elitefacade.ui.navgraphs

sealed class Screen(val route: String) {
    object Splash : Screen("splash") // загрузка
    object SingIn : Screen("sing_in")
    object SingUp : Screen("sing_up")
    object Registration : Screen("registration")
    object NavBarClient : Screen("nav_bar_client")
    object NavBarEmployee : Screen("nav_bar_employee")

}
