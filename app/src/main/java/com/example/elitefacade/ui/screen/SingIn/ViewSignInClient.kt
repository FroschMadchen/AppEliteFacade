package com.example.elitefacade.ui.screen.SingIn

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.backgroundBtn
import com.example.elitefacade.presentation.theme.gradient0
import com.example.elitefacade.ui.screen.Screen


@Composable
fun ViewSingInClient(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(end = 16.dp, start = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.sign_in),
            style = (typography.titleLarge),
            modifier = Modifier.padding(top = 10.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = stringResource(id = R.string.sign_in_client),
            style = (typography.titleMedium),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
                .align(
                    Alignment.CenterHorizontally
                ),
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
        TextFieldView(stringResource(id = R.string.name))
        TextFieldView(stringResource(id = R.string.id_order))

        AdditionalFunSingIn()

        Button(
            onClick = {
                navController.navigate(Screen.NavBarClient.route)
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
                style = (typography.bodyLarge),
                color = Color.White
            )
        }
    }
}

@Composable
fun TextFieldView(hint: String) {
    var text by remember { mutableStateOf(hint) }

    TextField(

        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .border(
                width = 5.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onBackground,
                        MaterialTheme.colorScheme.onSurface
                    )
                ),
                shape = RoundedCornerShape(15.dp),
            ),
        value = text,
        onValueChange = {
            text = it
        },
        textStyle = (typography.titleSmall),
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
}


@Composable
fun AdditionalFunSingIn() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Row() {
            val checkedState = remember { mutableStateOf(true) }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = gradient0,
                    checkedColor = backgroundBtn,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            //Spacer(modifier = Modifier.width(5.dp))
            Text(
                stringResource(id = R.string.remember_me),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        val label = remember { mutableStateOf("Забыли данные входа?") }
        TextButton(onClick = { label.value = "Hello" }) {
            Text(
                text = label.value,
                color = MaterialTheme.colorScheme.onPrimary,
                style = (typography.titleSmall),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
            )
        }
    }
}