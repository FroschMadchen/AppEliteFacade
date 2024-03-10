package com.example.elitefacade.ui.entity

sealed class AuthResult {
    object Authorized : AuthResult()
    object Unauthorized : AuthResult()
    object UnknownError : AuthResult()
}