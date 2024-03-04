package com.example.elitefacade.ui.screen.SingIn.LoginVM


data class LoginUIState(
    var userName: String = "",
    var password: String = "",
    var successLogin:Boolean = false,

    var userNameError: Boolean = false,
    var passwordError: Boolean = false

)
