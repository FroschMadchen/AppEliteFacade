package com.example.elitefacade.screen.views.BottomNavigtionClient.Chat

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elitefacade.R
import com.example.elitefacade.screen.views.BottomNavigtionClient.BottomBar
import com.example.elitefacade.screen.views.BottomNavigtionClient.BottomNavGraph



@Preview
@Composable
fun ChatView() {
    Box(modifier = Modifier.fillMaxSize()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
               .fillMaxSize()
            .padding(end = 16.dp, start = 16.dp, top = 80.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(15.dp))
                .padding(end = 10.dp, start = 10.dp)
        ) {
            Text(
                text = "Чат пуст.\n Вы можете написать вашему менеджеру,Урюрюкову Станиславу, по возникшим вопросам. \n Рабочее время с 8:30 по 18:00.\n Спасибо, что вы с нами :)",
                style = (MaterialTheme.typography.titleMedium),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )

        }


        var text by remember { mutableStateOf("Введите сообщение") }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxSize()

        ) {
            Row(){
                TextField(

                    modifier = Modifier
                        .padding(end=10.dp)
                        .weight(1f)
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colorScheme.onBackground,
                                    MaterialTheme.colorScheme.onSurface
                                )
                            ),
                            shape = RoundedCornerShape(8.dp),
                        ),
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    textStyle = (MaterialTheme.typography.titleSmall),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        cursorColor = Color.Blue, // Настроить цвет курсора
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Red
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_send_m),
                    contentDescription = "icon send",
                    Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                )
            }

        }

    }}

}