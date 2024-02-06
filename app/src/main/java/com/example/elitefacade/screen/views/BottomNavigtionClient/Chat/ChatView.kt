package com.example.elitefacade.screen.views.BottomNavigtionClient.Chat

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun ChatView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "Тут чат", fontSize = 30.sp)
    }

}