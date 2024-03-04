package com.example.elitefacade.ui.screen.SingIn

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.model.entity.AuthResult
import com.example.elitefacade.ui.screen.Screen
import com.example.elitefacade.ui.screen.SingIn.LoginVM.LoginUIEvent
import com.example.elitefacade.ui.screen.SingIn.LoginVM.LoginViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
fun ViewSignInEmployee(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel(),
) {
    val context = LocalContext.current

    LaunchedEffect(loginViewModel.loginUiState){
        loginViewModel.authResult.collect{result ->
            when(result) {
                AuthResult.Authorized -> {
                    navController.navigate(Screen.NavBarEmployee.route)
                    context.showToast("успешный вход", Toast.LENGTH_LONG)
                }
                AuthResult.Unauthorized -> {

                    context.showToast("не получилось войти ", Toast.LENGTH_LONG)
                }
                AuthResult.UnknownError -> TODO()
            }
        }
    }
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
            style = (MaterialTheme.typography.labelMedium),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
                .align(
                    Alignment.CenterHorizontally
                ),
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )

        TextFieldView(
            stringResource(id = R.string.name),
            onTextChanged = {
                loginViewModel.onEvent(event = LoginUIEvent.UserNameCheck(it))
            })
        TextFieldView(
            stringResource(id = R.string.password),
            onTextChanged = {
                loginViewModel.onEvent(event =LoginUIEvent.PasswordCheck(it) )
            }
        )

        AdditionalFunSingIn()

        Button(
            onClick = {
                loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)

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
                stringResource(id = R.string.sign_in),
                style = (MaterialTheme.typography.bodyLarge),
                color = Color.White
            )
        }

       /* LaunchedEffect(loginViewModel.uiState) {
            val successLogin = loginViewModel.uiState.value.successLogin
            if (successLogin) {
                withContext(Dispatchers.Main) {
                    navController.navigate(Screen.NavBarEmployee.route)
                    context.showToast("успешный вход", Toast.LENGTH_LONG)
                }
            } else {
                withContext(Dispatchers.Main) {
                    context.showToast("не получилось войти ", Toast.LENGTH_LONG)
                }
            }
        }*/
    }
}



fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}



