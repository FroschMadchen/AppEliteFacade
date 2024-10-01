package com.example.elitefacade.ui.screen.Login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.ui.entity.AuthResult
import com.example.elitefacade.presentation.theme.backgroundBtn
import com.example.elitefacade.presentation.theme.gradient0
import com.example.elitefacade.ui.generic.ButtonComponent
import com.example.elitefacade.ui.generic.TextFieldView
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIEvent
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginViewModel
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.CLIENT
import com.example.elitefacade.ui.navgraphs.Screen
import com.example.elitefacade.ui.utils.isValidLength


@Composable
fun ViewSingInClient(
    onNavigateInBarClientScreen:() -> Unit = {},
            loginViewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var notSuccess by remember { mutableStateOf(false) }
    val state by loginViewModel.loginUiState.collectAsState()

    LaunchedEffect(loginViewModel.loginUiState) {
        loginViewModel.authResult.collect { result ->
            when (result) {
                AuthResult.Authorized -> {
                    onNavigateInBarClientScreen()
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
            .padding(end = 16.dp, start = 16.dp, top = 10.dp),
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
            style = MaterialTheme.typography.labelMedium,
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
            onTextChanged = {loginViewModel.onEvent(event = LoginUIEvent.UserNameCheck(it)) },
            errorStatus = false
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextFieldView(
            stringResource(id = R.string.id_order),
            onTextChanged = {  loginViewModel.onEvent(event = LoginUIEvent.PasswordCheck(it)) },
            errorStatus = false
        )
        if (notSuccess) {
            Text(
                text = "Имя или пароль введены неправильно",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onError,
                modifier = Modifier.padding(2.dp)
            )
        }

        PasswordRecoveryView()

        ButtonComponent(
            stringResource(id = R.string.farther),
            onButtonClicked = { loginViewModel.loginUiState.value.position = CLIENT
                loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked) },
            onUnavailable = state.let {
                it.userName.isValidLength(6) &&
                        it.password.isValidLength(6)
            }
        )
    }
}



@Composable
fun PasswordRecoveryView() {
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


