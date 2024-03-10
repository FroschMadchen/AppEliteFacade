package com.example.elitefacade.domain

import com.example.elitefacade.domain.model.User

interface LoginResultCallback  {
    fun onLoginSuccess(userData: User)
    fun onLoginFailed()
}