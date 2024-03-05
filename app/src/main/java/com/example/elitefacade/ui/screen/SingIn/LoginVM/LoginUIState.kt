package com.example.elitefacade.ui.screen.SingIn.LoginVM


data class LoginUIState(
    var userName: String = "",
    var password: String = "",
    var userNameError: Boolean = false,
    var passwordError: Boolean = false,
    var onUnavailable:Boolean=false
)
