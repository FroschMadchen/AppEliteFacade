package com.example.elitefacade.ui.screen.Registration

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.backgroundBtn
import com.example.elitefacade.presentation.theme.gradient0
import com.example.elitefacade.ui.generic.ButtonComponent
import com.example.elitefacade.ui.generic.TextFieldSingUp
import com.example.elitefacade.ui.generic.TextFieldSingUpPassword
import com.example.elitefacade.ui.screen.Screen
import com.example.elitefacade.ui.utils.isValidLength


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel = viewModel()
) {
    val state by signUpViewModel.registrationUIState.collectAsState()
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
            val password1: MutableState<String> =
                remember {
                    mutableStateOf("")
                }
            val password2: MutableState<String> =
                remember {
                    mutableStateOf("")
                }
            val context = LocalContext.current
            Box(Modifier.padding(start = 16.dp, end = 16.dp)) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState()) // Добавляем прокрутку по вертикали
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    TextFieldSingUp(
                        title = stringResource(id = R.string.sign_up_user_name),
                        hint = stringResource(id = R.string.sign_up_user_name_hint),
                        icon = R.drawable.icon_project_manager,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.UserNameChanged(it))
                        },
                        errorStatus = state.userName.isValidLength(6)
                    )

                    TwoExclusiveCheckBoxes(onTextChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.positionChanged(it))
                    }, errorStatus = state.position.isNotEmpty())


                    TextFieldSingUp(
                        title = stringResource(id = R.string.sing_up_job_header),
                        hint = stringResource(id = R.string.sing_up_job_hint),
                        icon = R.drawable.icon_project_manager,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.jobTitleChanged(it))
                        },
                        errorStatus = state.jobTitle.isValidLength(4)
                    )
                    TextFieldSingUp(
                        title = stringResource(id = R.string.sing_up_email_header),
                        hint = stringResource(id = R.string.sing_up_email_hint),
                        icon = R.drawable.icon_sing_up_email,
                        onTextChanged = {
                            signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                        },
                        errorStatus = state.email.isNotEmpty()

                    )
                    TextFieldSingUpPassword(
                        title = stringResource(id = R.string.sing_up_password_header),
                        hint = stringResource(id = R.string.sing_up_password_hint),
                        onTextChanged = {
                            password2.value = it
                        },
                        errorStatus = true,
                        errorStatusIdentity = true
                    )
                    TextFieldSingUpPassword(
                        title = stringResource(id = R.string.sing_up_password2_header),
                        hint = stringResource(id = R.string.sing_up_password2_hint),
                        onTextChanged = {
                            password1.value = it
                            if (it == password2.value) {
                                signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
                                Log.i("RegistrationScreen", "$it  -- ${password2.value}")
                            } else {
                                Log.i("RegistrationScreen", "$it  -- ${password2.value}")
                            }
                        },
                        errorStatus = state.password.isValidLength(6),
                        errorStatusIdentity = (password1.value == password2.value)


                    )

                    ButtonComponent(
                        value = stringResource(id = R.string.farther),
                        onButtonClicked = {
                            signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClicked)
                            navController.navigate(Screen.NavBarEmployee.route)
                        },
                        onUnavailable = state.let {
                            it.email.isNotEmpty() &&
                            it.password.isValidLength(6) &&
                            it.userName.isValidLength(6) &&
                            it.jobTitle.isValidLength(4) &&
                            it.position.isNotEmpty() },
                    )
                }
            }
        }
    }
}

@Composable
fun TwoExclusiveCheckBoxes(onTextChanged: (String) -> Unit, errorStatus: Boolean = false) {
    var isChecked1 by remember { mutableStateOf(false) }
    var isChecked2 by remember { mutableStateOf(false) }


    val textEmployee = stringResource(id = R.string.employee)
    val textClient = stringResource(id = R.string.client)

    var selectedText by remember { mutableStateOf("") }
    onTextChanged(selectedText)
    Column {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)

        ) {
            Row(modifier = Modifier.weight(1f)) {
                Checkbox(
                    checked = isChecked1,
                    onCheckedChange = {
                        isChecked1 = it

                        if (isChecked1) {
                            selectedText = textEmployee
                        }

                        if (!isChecked1) {
                            isChecked2 =
                                true // Если другой чекбокс не выбран, установите его состояние как true
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
            Row(modifier = Modifier.weight(1f)) {
                Checkbox(
                    checked = isChecked2,
                    onCheckedChange = {
                        isChecked2 = it

                        if (!isChecked2) {
                            isChecked1 =
                                true // Если другой чекбокс не выбран, установите его состояние как true
                        }

                        if (isChecked2) {

                            selectedText = textClient

                        }
                    },
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
        if (!errorStatus) {
            Text(
                text = "Необходимо выбрать одну позицию",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }


    }

    LaunchedEffect(isChecked1) {
        if (isChecked1) isChecked2 = false
    }

    LaunchedEffect(isChecked2) {
        if (isChecked2) isChecked1 = false
    }

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
