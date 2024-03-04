package com.example.elitefacade.model.entity

sealed class AuthResult {
    object Authorized : AuthResult()
    object Unauthorized : AuthResult()
    object UnknownError : AuthResult()
}