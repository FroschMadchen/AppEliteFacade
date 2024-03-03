package com.example.elitefacade.ui.screen.SingIn.LoginVM

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.example.elitefacade.ui.screen.rules.ValidatorSingUp
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel: ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    private var loginUIState = mutableStateOf(LoginUIState())

    private var allValidationsPassed = mutableStateOf(false)

    private var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.userNameChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    userName = event.userName
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = ValidatorSingUp.validateNameUser(
            userName = loginUIState.value.userName
        )

        val passwordResult = ValidatorSingUp.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            userNameError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        loginInProgress.value = true
        val userName = loginUIState.value.userName
        val password = loginUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(userName, password)
            .addOnCompleteListener {
                Log.d(TAG,"Inside_login_success")
                Log.d(TAG,"${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    //ostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG,"Inside_login_failure")
                Log.d(TAG,"${it.localizedMessage}")

                loginInProgress.value = false

            }

    }
}