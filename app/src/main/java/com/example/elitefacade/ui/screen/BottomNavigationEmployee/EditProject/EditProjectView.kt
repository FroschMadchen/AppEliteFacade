package com.example.elitefacade.ui.screen.BottomNavigationEmployee.EditProject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.elitefacade.ui.utils.ItemProjectList

@Composable
fun EditProjectView() {
    Column(Modifier.padding(start=10.dp,end=10.dp)) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            itemsIndexed(
                listOf(TitleProjectState("OOO Висакос","Шушорова Е. Л.",""),
                    TitleProjectState("OAO Бучих","Мандавошкина Ю.Б.",""),
                    TitleProjectState("OAO Бучих","Мандавошкина Ю.Б.",""),
                    TitleProjectState("OAO Бучих","Мандавошкина Ю.Б.",""),
                    TitleProjectState("OAO Бучих","Мандавошкина Ю.Б.","")

                )
            ) { index, item ->

                ItemProjectList(
                    nameCompany = item.nameCompany,
                    item.nameManager
                )
            }
        } /*destination = when (index) {
        0 -> Route.LIST_PRODUCTS_SCREEN
        1 -> Route.UNAVAILABLE
        2 -> Route.UNAVAILABLE
        else -> ""
    }*/
    }
}