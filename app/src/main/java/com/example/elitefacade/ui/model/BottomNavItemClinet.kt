package com.example.elitefacade.ui.model


import com.example.elitefacade.R


sealed class BottomNavItemClinet(
    val route: String,
    val iconResId: Int,
    val label: String,
    val badgeCount: Int? = null
) {

    object Order :
        BottomNavItemClinet(
            "Order",
            iconResId = R.drawable.icon_delivery,
            "Заказ"
        )

    object Chat :
        BottomNavItemClinet(
            "Chat",
            iconResId = R.drawable.icon_chat_f_2,
            "Чат",
            badgeCount = 12
        )

    companion object {
        val allItems: List<BottomNavItemClinet> by lazy {
            listOf(Order, Chat) // Список всех объектов BottomNavItem
        }
    }
}
