package com.example.elitefacade.ui.screen.Login

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.EliteFacadeTheme
import com.example.elitefacade.ui.entity.AuthResult
import com.example.elitefacade.ui.generic.TextFieldView
import com.example.elitefacade.ui.navgraphs.Screen
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIEvent
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginViewModel
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.EMPLOYEE
import com.example.elitefacade.ui.screen.Registration.RegistrationScreen
import com.example.elitefacade.ui.utils.isValidLength


@SuppressLint("SuspiciousIndentation")
@Composable
fun ViewSignInEmployee(
    onNavigateInBarEmployeeScreen:() -> Unit = {},
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    var notSuccess by remember { mutableStateOf(false) }
    val state by loginViewModel.loginUiState.collectAsState()

    LaunchedEffect(loginViewModel.loginUiState) {
        loginViewModel.authResult.collect { result ->
            when (result) {
                AuthResult.Authorized -> {
                    onNavigateInBarEmployeeScreen()
                    context.showToast("успешный вход", Toast.LENGTH_LONG)
                }

                AuthResult.Unauthorized -> {
                    notSuccess = true
                }
                AuthResult.UnknownError -> TODO()
            }
        }
    }
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(end = 16.dp, start = 16.dp,top=10.dp),
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
            },
            errorStatus = state.userName.isValidLength(6)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextFieldView(
            stringResource(id = R.string.password),
            onTextChanged = {
                loginViewModel.onEvent(event = LoginUIEvent.PasswordCheck(it))
            },
            errorStatus = state.password.isValidLength(6)
        )
        if (notSuccess) {
            Text(
                text = "Имя или пароль введены неправильно",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onError,
                modifier = Modifier.padding(2.dp)
            )
        }

        Button(
            onClick = {
                loginViewModel.loginUiState.value.position = EMPLOYEE
                loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked) },
            enabled = state.let {
                it.userName.isValidLength(6) &&
                        it.password.isValidLength(6)
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onSecondary,
                containerColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier
                .padding(top = 10.dp, end = 10.dp, start = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                stringResource(id = R.string.farther),
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





