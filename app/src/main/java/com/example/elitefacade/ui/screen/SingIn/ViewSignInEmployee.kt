package com.example.elitefacade.ui.screen.SingIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.ui.screen.Screen


@Composable
fun ViewSignInEmployee(navController: NavController) {

    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(end = 16.dp, start = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.sign_in),
            style = (MaterialTheme.typography.titleLarge),
            modifier = Modifier.padding(top = 10.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = stringResource(id = R.string.sign_in_employee),
            style = (MaterialTheme.typography.titleMedium),
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
        TextFieldView(stringResource(id = R.string.password))

        AdditionalFunSingIn()

        Button(
            onClick = { navController.navigate(Screen.NavBarEmployee.route) },
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
                stringResource(id = R.string.sign_in),
                style = (MaterialTheme.typography.bodyLarge),
                color = Color.White
            )
        }
    }
}



