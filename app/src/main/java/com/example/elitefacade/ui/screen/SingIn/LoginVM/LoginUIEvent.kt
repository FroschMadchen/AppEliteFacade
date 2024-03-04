package com.example.elitefacade.ui.screen.SingIn.LoginVM

sealed class LoginUIEvent{

    data class UserNameCheck(val userName:String): LoginUIEvent()
    data class PasswordCheck(val password: String) : LoginUIEvent()

    object LoginButtonClicked : LoginUIEvent()
}