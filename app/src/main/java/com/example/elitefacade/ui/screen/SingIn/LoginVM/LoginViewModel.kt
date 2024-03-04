package com.example.elitefacade.ui.screen.SingIn.LoginVM

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.elitefacade.ui.screen.AppSession
import com.example.elitefacade.ui.screen.rules.ValidatorSingUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow


class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var success by mutableStateOf(false)
        private set

    //   private var allValidationsPassed = mutableStateOf(false)

    private var loginInProgress = mutableStateOf(false)

    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.UserNameCheck -> {
                loginUIState.value = loginUIState.value.copy(
                    userName = event.userName
                )
            }

            is LoginUIEvent.PasswordCheck -> {
                loginUIState.value = loginUIState.value.copy(
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
            userName = loginUIState.value.userName
        )

        val passwordResult = ValidatorSingUp.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            userNameError = emailResult.status,
            passwordError = passwordResult.status
        )

        //    allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    //   loginInProgress.value = true
    private fun login() {

        val userName = loginUIState.value.userName
        val password = loginUIState.value.password

        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("user_employee")
        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var userFound = false // Флаг для отслеживания успешного поиска пользователя

                for (snapshot in dataSnapshot.children) {
                    val userData = snapshot.getValue(User::class.java)
                    if (userData != null && userData.userName == userName && userData.password == password) {
                        // Найден пользователь с заданным именем пользователя и паролем
                        userFound = true
                        AppSession.userNameSession = userData.userName
                        AppSession.emailSession = userData.email
                        AppSession.jobTitleSession = userData.jobTitle
                        break // Нет смысла продолжать поиск, если пользователь найден
                    }
                }
                // Устанавливаем состояние в зависимости от результата поиска
                _uiState.value.successLogin = userFound
                success = userFound

                if (userFound) {
                    Log.i(TAG, "Успешный вход пользователя: $userName")
                } else {
                    Log.i(TAG, "Пользователь не найден или неверный пароль: $userName")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Обработка ошибки при чтении данных
                Log.e(TAG, "Error reading data", databaseError.toException())
            }
        })

        /* reference.addListenerForSingleValueEvent(object : ValueEventListener {
             override fun onDataChange(dataSnapshot: DataSnapshot) { // Проверяем, есть ли данные в узле
                 if (dataSnapshot.exists()) { // Проверяем наличие определенных данных
                     for (snapshot in dataSnapshot.children) {
                         val userData = snapshot.getValue(User::class.java)
                         if (userData != null && userData.userName == userName && userData.password == password) {
                             _uiState.value.successLogin= true
                             Log.i(TAG," ${userData.userName} - $userName ")
                             AppSession.userNameSession=userData.userName
                             AppSession.emailSession = userData.email
                             AppSession.jobTitleSession=userData.jobTitle
                             // Найден пользователь с заданным именем пользователя и паролем
                             Log.e(TAG,"success login ")
                         }
                     }
                 } else {
                     Log.e(TAG,"error login, данные не найдены в db ")
                     _uiState.value.successLogin= false
                     // Узел пустой, данные не найдены
                     // Здесь можно выполнить нужные действия в случае отсутствия данных
                 }
             }

             override fun onCancelled(databaseError: DatabaseError) {
                 // Обработка ошибки при чтении данных
                 Log.e(TAG, "Error reading data", databaseError.toException())
             }
         })
 */
        /*  FirebaseAuth
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

              }*/

    }
}