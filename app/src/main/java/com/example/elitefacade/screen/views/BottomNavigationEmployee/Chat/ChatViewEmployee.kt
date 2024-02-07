package com.example.elitefacade.screen.views.BottomNavigationEmployee.Chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatEmployeeView() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text("Chat",
            Modifier
                .align(Alignment.Center)
                .size(30.dp))
    }
}