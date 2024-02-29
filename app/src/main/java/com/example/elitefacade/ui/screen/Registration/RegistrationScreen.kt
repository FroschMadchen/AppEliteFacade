package com.example.elitefacade.ui.screen.Registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.elitefacade.R
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.BottomNavGraphEmployee
import com.example.elitefacade.ui.screen.Screen
import com.example.elitefacade.ui.screen.SingIn.TextFieldView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavHostController) {

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            title = { },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_back),
                        contentDescription = "Back", Modifier.size(30.dp)
                    )
                }
            }
        )
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            RegistrationScreenBox(navController = navController)
        }

    }
}


@Composable
fun RegistrationScreenBox(navController: NavHostController) {
    Box(Modifier.padding(start=16.dp,end=16.dp)) {
        Column {
            Text(
                text = "Регистрация сотрудника",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
            TextFieldView("ФИО нового сотрудника")
            TextFieldView("Должность нового сотрудника")
            Text(
                text = "Для потверждения регистрации введите emil",
                Modifier.padding(4.dp),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )

            TextFieldView("Введите email")

            Text(
                text = "Cоздание пароля",
                Modifier.padding(4.dp),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            TextFieldView("Введите пароль")
            TextFieldView("Введите пароль повторно")


            Button(
                onClick = {
                    navController.navigate(Screen.RegistrationGetCode.route)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    containerColor = MaterialTheme.colorScheme.onSecondary
                ),
                modifier = Modifier
                    .padding(top = 15.dp, end = 10.dp, start = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)

            ) {
                Text(
                    stringResource(id = R.string.farther),
                    style = (MaterialTheme.typography.bodyLarge),
                    color = Color.White
                )
            }
        }
    }
}