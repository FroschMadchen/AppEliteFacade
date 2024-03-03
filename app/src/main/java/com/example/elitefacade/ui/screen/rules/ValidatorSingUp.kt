package com.example.elitefacade.ui.screen.rules

object ValidatorSingUp {

    fun validateNameUser(userName: String): ValidationResult {
        return ValidationResult(
            (userName.isNotEmpty() && userName.length >= 10)
        )
    }

    fun validateJobTitle(userJobTitle: String): ValidationResult {
        return ValidationResult(userJobTitle.isNotEmpty() && userJobTitle.length >= 4)
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (email.isNotEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 6)
        )
    }
}


data class ValidationResult(
    val status: Boolean = false
)