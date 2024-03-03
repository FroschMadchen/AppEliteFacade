package com.example.elitefacade.ui.screen.Registration


data class RegistrationUIState(
    var userName :String = "",
    var jobTitle  :String = "",
    var email  :String = "",
    var password  :String = "",
 //   var privacyPolicyAccepted :Boolean = false,


    var userNameError :Boolean = false,
    var jobTitleError : Boolean = false,
    var emailError :Boolean = false,
    var passwordError : Boolean = false,
   // var privacyPolicyError:Boolean = false
)