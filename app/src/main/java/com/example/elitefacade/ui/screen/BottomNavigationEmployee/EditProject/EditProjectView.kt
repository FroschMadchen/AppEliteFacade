package com.example.elitefacade.ui.screen.BottomNavigationEmployee.EditProject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.elitefacade.R
import com.example.elitefacade.ui.generic.ItemProjectList

@Composable
fun EditProjectView() {
    Column(Modifier.padding(start = 10.dp, end = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, start = 10.dp)
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_add),
                contentDescription = "",
                modifier = Modifier
                    .padding(5.dp)
                    .size(25.dp)
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            itemsIndexed(
                listOf(
                    TitleProjectState("OOO Висакос", "Василенко В. Б.", ""),
                    TitleProjectState("OAO Китчен Пасс", "Баварских  О. К.", ""),
                    TitleProjectState("OAO Симпл ", "Кан М.Е.", ""),
                    TitleProjectState("OAO Рич", "Василенко В. Б.", ""),
                    TitleProjectState("OAO Миксомания", "Баварских  О. К.", ""),
                    TitleProjectState("OAO АСТ", "Кан М.Е.", ""),
                    TitleProjectState("OAO ЛистРос", "Кан М.Е.", ""),
                    TitleProjectState("ООО Берег", "Кан М.Е.", ""),
                    TitleProjectState("OAO ФасадЧеб", "Кан М.Е.", ""),
                    TitleProjectState("OОО РыбБаза", "Кан М.Е.", "")

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