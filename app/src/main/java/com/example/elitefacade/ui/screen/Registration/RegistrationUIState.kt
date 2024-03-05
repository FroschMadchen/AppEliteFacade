package com.example.elitefacade.ui.screen.Registration


data class RegistrationUIState(
    var userName :String = "",
    var jobTitle  :String = "",
    var email  :String = "",
    var password  :String = "",
    var position: String ="",



    var userNameValidate :Boolean = false,
    var jobTitleValidate : Boolean = false,
    var emailValidate :Boolean = false,
    var passwordValidate : Boolean = false,
    var positionValidate : Boolean = false
    ,
    var buttonRegisteration:Boolean = false
)