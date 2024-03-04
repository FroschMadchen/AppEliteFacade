package com.example.elitefacade.ui.screen.SingIn.LoginVM

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elitefacade.model.entity.AuthResult
import com.example.elitefacade.ui.screen.AppSession
import com.example.elitefacade.ui.screen.rules.ValidatorSingUp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch



class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    private val _loginUiState = MutableStateFlow(LoginUIState())
    val loginUiState = _loginUiState.asStateFlow()
    private val _resultChannel = Channel<AuthResult>()
    val authResult = _resultChannel.receiveAsFlow()

    //   private var allValidationsPassed = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.UserNameCheck -> {
                _loginUiState.value = loginUiState.value.copy(
                    userName = event.userName
                )
            }

            is LoginUIEvent.PasswordCheck -> {
                _loginUiState.value = loginUiState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
                Log.i(TAG, "кнопка нажата  ")
            }
        }
        //  validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = ValidatorSingUp.validateNameUser(
            userName = _loginUiState.value.userName
        )

        val passwordResult = ValidatorSingUp.validatePassword(
            password = _loginUiState.value.password
        )

        _loginUiState.value = _loginUiState.value.copy(
            userNameError = emailResult.status,
            passwordError = passwordResult.status
        )

        //    allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        val userName = _loginUiState.value.userName
        val password = _loginUiState.value.password

        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("user_employee")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val userData = snapshot.getValue(User::class.java)
                    if (userData != null &&
                        userData.userName == userName &&
                        userData.password == password) {
                        // Найден пользователь с заданным именем пользователя и паролем

                        viewModelScope.launch {
                            _resultChannel.send(AuthResult.Authorized)
                        }
                        AppSession.userNameSession = userData.userName
                        AppSession.emailSession = userData.email
                        AppSession.jobTitleSession = userData.jobTitle
                        Log.i(TAG, "Успешный вход пользователя: $userName")
                        return
                    }
                    else {
                        viewModelScope.launch {
                            _resultChannel.send(AuthResult.Unauthorized)
                        }
                        Log.i(TAG, "Пользователь не найден или неверный пароль: $userName")
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Обработка ошибки при чтении данных
                Log.e(TAG, "Error reading data", databaseError.toException())
            }
        })
    }

}