package com.example.elitefacade.screen.model

import com.example.elitefacade.R

sealed class BottomNavItemEmployee(
    val route:String,
    val iconResId:Int,
    val label:String,
    val badgeCount:Int? = null
) {
    object ViewingProjects: BottomNavItemEmployee(
        route = "ViewingProjects",
        iconResId = R.drawable.icon_project_employee,
        label= "Просмотр"
    )
    object EditProjects:BottomNavItemEmployee(
        route = "EditProjects",
        iconResId = R.drawable.icon_project_edit,
        label= "Изменить"
    )
    object Chat:BottomNavItemEmployee(
        route = "Chat",
        iconResId = R.drawable.icon_chat_employee,
        label= "Чат",
        badgeCount = 56
    )
    object Profile:BottomNavItemEmployee(
        route = "Profile",
        iconResId = R.drawable.icon_profil_manager,
        label = "Профиль"
    )

    companion object {
        val allItems: List<BottomNavItemEmployee> by lazy {
            listOf(Profile,Chat,EditProjects,ViewingProjects) // Список всех объектов BottomNavItem
        }
    }

}