package com.example.elitefacade.domain

import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIState

interface UserRepository  {
    fun saveUserDataInFireBase(user: User)
    fun loginUserInFireBase(loginUIState: LoginUIState, callback: LoginResultCallback)
}