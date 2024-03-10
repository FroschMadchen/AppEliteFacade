package com.example.elitefacade.ui.screen.Login.LoginViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elitefacade.data.DataStore.DataStoreManager
import com.example.elitefacade.data.UserRepositoryImpl
import com.example.elitefacade.domain.LoginResultCallback
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.entity.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl,
    private val dataStoreManager: DataStoreManager
) :
    ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    private val _loginUiState = MutableStateFlow(LoginUIState())
    val loginUiState = _loginUiState.asStateFlow()
    private val _resultChannel = Channel<AuthResult>()
    val authResult = _resultChannel.receiveAsFlow()

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
                Log.i(TAG, "успешная проверка на корректность вводимых данных ")
            }
        }
    }


    private fun login() {

        val userName = _loginUiState.value.userName
        val password = _loginUiState.value.password
        val position = _loginUiState.value.position
        userRepository.loginUserInFireBase(LoginUIState(userName, password, position),
            object : LoginResultCallback {
                override fun onLoginSuccess(userData: User) {
                    viewModelScope.launch {
                        _resultChannel.send(AuthResult.Authorized)
                        dataStoreManager.saveSessionUser(
                            User(
                                data = userData.data,
                                email = userData.email,
                                idCreator = userData.idCreator,
                                jobTitle = userData.jobTitle,
                                key = userData.key,
                                userName = userData.userName,
                                password = userData.password,
                                position = userData.position
                            )
                        )


                        Log.i(
                            TAG,
                            "Успешное сохранение в dataStore: ${userData.userName}"
                        )
                    }
                }

                override fun onLoginFailed() {
                    TODO("Ошибка при проверке данных в FireBase")
                }
            })
    }
}