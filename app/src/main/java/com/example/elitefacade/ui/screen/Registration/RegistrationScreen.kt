package com.example.elitefacade.ui.screen.Registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.elitefacade.ui.screen.SingIn.TextFieldView

@Preview
@Composable
fun RegistrationScreen(){
    Box(){
        Column {
            TextFieldView("ФИО нового сотрудника")
            TextFieldView("Введите email")
            Button(onClick = { /*TODO*/ }) {
                Text("Продолжить")
            }
        }
    }
}