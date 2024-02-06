package com.example.elitefacade.screen.model


import com.example.elitefacade.R


sealed class BottomNavItem(
    val route: String,
    val iconResId: Int,
    val label: String,
    val badgeCount: Int? = null
) {

    object Order :
        BottomNavItem(
            "Order",
            iconResId = R.drawable.icon_compliance,
            "Заказ"
        )

    object Chat :
        BottomNavItem(
            "Chat",
            iconResId = R.drawable.icon_chat_1,
            "Чат",
            badgeCount = 12
        )

    companion object {
        val allItems: List<BottomNavItem> by lazy {
            listOf(Order, Chat) // Список всех объектов BottomNavItem
        }
    }
}
