package com.example.elitefacade.ui.screen.Login.LoginViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elitefacade.data.UserRepositoryImpl
import com.example.elitefacade.domain.UserRepository
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.entity.AuthResult
import com.example.elitefacade.ui.screen.AppSession
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.CLIENT
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.EMPLOYEE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepositoryImpl) : ViewModel() {
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
        //  userRepository.loginUserInFireBase(LoginUIState(userName,password,position))


        /*     val database = FirebaseDatabase.getInstance()
             val referenceEmployee = database.getReference("user_employee")
             val referenceClient = database.getReference("user_client")*/

        /*    when (position) {
                EMPLOYEE -> referenceEmployee.addListenerForSingleValueEvent(object :
                    ValueEventListener {

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            val userData = snapshot.getValue(User::class.java)
                            if (userData != null &&
                                userData.userName == userName &&
                                userData.password == password
                            ) {
                                // Найден пользователь с заданным именем пользователя и паролем

                                viewModelScope.launch {
                                    _resultChannel.send(AuthResult.Authorized)
                                }
                                AppSession.userNameSession = userData.userName
                                AppSession.emailSession = userData.email
                                AppSession.jobTitleSession = userData.jobTitle
                                AppSession.keyUserSession = userData.key
                                Log.i(TAG, "Успешный вход пользователя: $userName")
                                return
                            } else {
                                viewModelScope.launch {
                                    _resultChannel.send(AuthResult.Unauthorized)
                                    Log.i(TAG, "Пользователь не найден или неверный пароль: $userName")
                                }

                            }
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Обработка ошибки при чтении данных
                        Log.e(TAG, "Error reading data", databaseError.toException())
                    }
                })

                CLIENT -> referenceClient.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            val userData = snapshot.getValue(User::class.java)
                            if (userData != null &&
                                userData.userName == userName &&
                                userData.password == password
                            ) {
                                // Найден пользователь с заданным именем пользователя и паролем

                                viewModelScope.launch {
                                    _resultChannel.send(AuthResult.Authorized)
                                }
                                AppSession.userNameSession = userData.userName
                                AppSession.emailSession = userData.email
                                AppSession.jobTitleSession = userData.jobTitle
                                AppSession.keyUserSession = userData.key
                                Log.i(TAG, "Успешный вход пользователя: $userName")
                                return
                            } else {
                                viewModelScope.launch {
                                    _resultChannel.send(AuthResult.Unauthorized)
                                    Log.i(TAG, "Пользователь не найден или неверный пароль: $userName")
                                }

                            }
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Обработка ошибки при чтении данных
                        Log.e(TAG, "Error reading data", databaseError.toException())
                    }
                })
            }*/
    }

}