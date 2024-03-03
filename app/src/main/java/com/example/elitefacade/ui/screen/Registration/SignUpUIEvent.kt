package com.example.elitefacade.ui.screen.Registration

sealed class SignUpUIEvent{

    data class UserNameChanged(val userName:String) : SignUpUIEvent()
    data class jobTitleChanged(val jobTitle:String) : SignUpUIEvent()
    data class EmailChanged(val email:String): SignUpUIEvent()
    data class PasswordChanged(val password: String) : SignUpUIEvent()

    //data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : SignUpUIEvent()

    object RegisterButtonClicked : SignUpUIEvent()
}