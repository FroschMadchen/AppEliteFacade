package com.example.elitefacade.ui.screen.Registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.backgroundBtn
import com.example.elitefacade.presentation.theme.gradient0
import com.example.elitefacade.ui.generic.ButtonComponent
import com.example.elitefacade.ui.generic.TextFieldSingUp
import com.example.elitefacade.ui.screen.SingIn.LoginVM.LoginUIEvent
import com.example.elitefacade.ui.screen.SingIn.LoginVM.LoginViewModel
import com.example.elitefacade.ui.screen.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel = viewModel()
) {
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
            Box(Modifier.padding(start = 16.dp, end = 16.dp)) {
                Column {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        Modifier
                            .padding(10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    TextFieldSingUp(
                        title = stringResource(id = R.string.sign_up_user_name),
                        hint = stringResource(id = R.string.sign_up_user_name_hint),
                        icon = R.drawable.icon_project_manager, false,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.UserNameChanged(it))
                        },
                        errorStatus = signUpViewModel.registrationUIState.value.userNameError
                    )

                    val position = TwoExclusiveCheckBoxes()

                    TextFieldSingUp(
                        title = stringResource(id = R.string.sing_up_job_header),
                        hint = stringResource(id = R.string.sing_up_job_hint),
                        icon = R.drawable.icon_project_manager, false,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.jobTitleChanged(it))
                        },
                        errorStatus = signUpViewModel.registrationUIState.value.jobTitleError
                    )
                    TextFieldSingUp(
                        title = stringResource(id = R.string.sing_up_email_header),
                        hint = stringResource(id = R.string.sing_up_email_hint),
                        icon = R.drawable.icon_sing_up_email, false,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                        },
                        errorStatus = signUpViewModel.registrationUIState.value.emailError

                    )
                    TextFieldSingUp(
                        title = stringResource(id = R.string.sing_up_password_header),
                        hint = stringResource(id = R.string.sing_up_password_hint),
                        icon = R.drawable.icon_project_manager, true,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
                        },
                        errorStatus = signUpViewModel.registrationUIState.value.passwordError
                    )
                    /*  TextFieldSingUp(
                          title = stringResource(id = R.string.sing_up_password2_header),
                          hint = stringResource(id = R.string.sing_up_password2_hint),
                          icon = R.drawable.icon_project_manager, true
                      )*/

                    ButtonComponent(
                        value = stringResource(id = R.string.farther),
                        onButtonClicked = {
                            signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClicked)
                            navController.navigate(Screen.NavBarEmployee.route)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun TwoExclusiveCheckBoxes():String{
    var isChecked1 by remember { mutableStateOf(false) }
    var isChecked2 by remember { mutableStateOf(false) }

    val textEmployee = stringResource(id = R.string.employee)
    val textClient = stringResource(id = R.string.client)

    var selectedText by remember { mutableStateOf("") }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)

    ) {
        Row( modifier = Modifier.weight(1f)) {
            Checkbox(
                checked = isChecked1,
                onCheckedChange = {
                    isChecked1 = it
                    if (isChecked1) {
                        selectedText = textEmployee
                    }
                },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = gradient0,
                    checkedColor = backgroundBtn,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            Text(
                text = textEmployee,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

        }

        // Spacer(modifier = Modifier.height(16.dp))
        Row( modifier = Modifier.weight(1f)) {
            Checkbox(
                checked = isChecked2,
                onCheckedChange = { isChecked2 = it
                    if (isChecked1) {
                        selectedText = textClient
                    }},
                colors = CheckboxDefaults.colors(
                    uncheckedColor = gradient0,
                    checkedColor = backgroundBtn,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                ),

                )
            Text(
                text = textClient,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }

    LaunchedEffect(isChecked1) {
        if (isChecked1) isChecked2 = false
    }

    LaunchedEffect(isChecked2) {
        if (isChecked2) isChecked1 = false
    }
    return selectedText
}


@Preview
@Composable
fun PreviewTwoExclusiveCheckBoxes() {
    TwoExclusiveCheckBoxes()
}
/*   Text(
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
                    TextFieldView("Введите пароль повторно")*/
