package com.example.elitefacade.domain

import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIState
import com.example.elitefacade.domain.model.User
import javax.inject.Inject

interface UserRepository  {

    fun saveUserDataInFireBase(user: User)

    fun loginUserInFireBase(loginUIState: LoginUIState)

}