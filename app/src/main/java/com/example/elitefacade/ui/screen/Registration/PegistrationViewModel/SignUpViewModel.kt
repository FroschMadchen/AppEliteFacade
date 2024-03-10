package com.example.elitefacade.ui.screen.Registration.PegistrationViewModel


import android.text.format.DateFormat
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.elitefacade.R
import com.example.elitefacade.data.UserRepositoryImpl
import com.example.elitefacade.domain.UserRepository
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.screen.AppSession
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date
import javax.inject.Inject
import kotlin.random.Random

const val EMPLOYEE: String = "Сотрудник"
const val CLIENT: String = "Заказчик"

@HiltViewModel
class SignUpViewModel @Inject constructor(
   private val userRepository: UserRepositoryImpl
) : ViewModel() {
    private val TAG = SignUpViewModel::class.simpleName

    private val _registrationUIState = MutableStateFlow(SingUpUIState())
    val registrationUIState = _registrationUIState.asStateFlow()

    //   private var allValidationsPassed = mutableStateOf(false) //не использовать

    private var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUIEvent) {
        when (event) {
            is SignUpUIEvent.UserNameChanged -> {
                _registrationUIState.value = _registrationUIState.value.copy(
                    userName = event.userName
                )
                printState()
            }

            is SignUpUIEvent.jobTitleChanged -> {
                _registrationUIState.value = _registrationUIState.value.copy(
                    jobTitle = event.jobTitle
                )
                printState()
            }

            is SignUpUIEvent.EmailChanged -> {
                _registrationUIState.value = _registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is SignUpUIEvent.PasswordChanged -> {
                _registrationUIState.value = _registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is SignUpUIEvent.positionChanged -> {
                _registrationUIState.value = _registrationUIState.value.copy(
                    position = event.position
                )
                printState()
            }

            is SignUpUIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printState()
        //  if (allValidationsPassed.value) {
        createUserInFirebase(
            email = _registrationUIState.value.email,
            password = _registrationUIState.value.password,
            jobTitle = _registrationUIState.value.jobTitle,
            userName = _registrationUIState.value.userName,
            position = _registrationUIState.value.position
        )


    }

    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, _registrationUIState.value.toString())
    }


    private fun createUserInFirebase(
        email: String,
        password: String,
        jobTitle: String,
        userName: String,
        position: String
    ) {
        signUpInProgress.value = true
        val key = createKey()
     /*   val userData = hashMapOf(
            "data" to createCaption(),
            "email" to email,
            "idCreator" to AppSession.keyUserSession,
            "jobTitle" to jobTitle,
            "key" to key,
            "userName" to userName,
            "password" to password,
            "position" to position
        )*/

   /*     userRepository.saveUserDataInFireBase(
            User(
                data = createCaption(),
                email = email,
                idCreator = AppSession.keyUserSession,
                jobTitle = jobTitle,
                key = key,
                userName = userName,
                password = password,
                position = position,
                )
        )*/

        Log.i(TAG, "signUpInProgress")
        /* when(position){
           EMPLOYEE-> FirebaseDatabase.getInstance().getReference("user_employee")
                 .child(key)//.child(uid)
                 .setValue(userData)
                 .addOnSuccessListener {
                     Log.d(TAG, "User data successfully written!")
                     // Пользователь успешно создан и данные сохранены в Realtime Database
                 }
                 .addOnFailureListener { e ->
                     Log.e(TAG, "Error writing document", e)
                     // Ошибка при сохранении данных в Realtime Database
                 }
            CLIENT ->  FirebaseDatabase.getInstance().getReference("user_client")
                 .child(key)//.child(uid)
                 .setValue(userData)
                 .addOnSuccessListener {
                     Log.d(TAG, "User data successfully written!")
                     // Пользователь успешно создан и данные сохранены в Realtime Database
                 }
                 .addOnFailureListener { e ->
                     Log.e(TAG, "Error writing document", e)
                     // Ошибка при сохранении данных в Realtime Database
                 }
             else -> Log.e(TAG,"Ошибка в createUserInFirebase")
         }


 */

    }

    private fun createCaption(): String =
        DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()

    private fun createKey(): String = Random.nextInt(1000, 9999).toString()

}

