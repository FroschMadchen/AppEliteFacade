package com.example.elitefacade.ui.screen.SingIn.LoginVM

sealed class LoginUIEvent{

    data class userNameChanged(val userName:String): LoginUIEvent()
    data class PasswordChanged(val password: String) : LoginUIEvent()
  //  data class jobTitleChanged(val jobTitleChanged: String):LoginUIEvent()

    object LoginButtonClicked : LoginUIEvent()
}