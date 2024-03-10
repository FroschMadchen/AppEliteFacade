package com.example.elitefacade.ui.screen.BottomNavigationEmployee.Profile.ProfileViewModel

sealed class ProfileUIEvent {

    data class EditPassword(val passwordNew: String) : ProfileUIEvent()
    data class EditEmail(val emailNew: String) : ProfileUIEvent()
    data class EditNameUserAndJobTitle(val userNameNew: String, val userJobTitle: String) :
        ProfileUIEvent()

}
