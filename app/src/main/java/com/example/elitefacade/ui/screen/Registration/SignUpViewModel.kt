package com.example.elitefacade.ui.screen.Registration


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.elitefacade.ui.screen.rules.ValidatorSingUp
import com.google.firebase.database.FirebaseDatabase
import java.util.Date
import android.text.format.DateFormat
import com.example.elitefacade.ui.screen.AppSession
import kotlin.random.Random


class SignUpViewModel : ViewModel() {
    private val TAG = SignUpViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    private var allValidationsPassed = mutableStateOf(false)

    private var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUIEvent) {
        when (event) {
            is SignUpUIEvent.UserNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    userName = event.userName
                )
                printState()
            }

            is SignUpUIEvent.jobTitleChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    jobTitle = event.jobTitle
                )
                printState()
            }

            is SignUpUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is SignUpUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is SignUpUIEvent.positionChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    position = event.position
                )
                printState()
            }

            is SignUpUIEvent.RegisterButtonClicked -> {
                signUp()
            }

            else -> {}
        }
        validateDataWithRules()
    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printState()
            if(allValidationsPassed.value){
                createUserInFirebase(
                    email = registrationUIState.value.email,
                    password = registrationUIState.value.password,
                    jobTitle = registrationUIState.value.jobTitle,
                    userName = registrationUIState.value.userName,
                    position = registrationUIState.value.position
                )
            }

    }

    private fun validateDataWithRules() {
        val userName = ValidatorSingUp.validateNameUser(
            userName = registrationUIState.value.userName
        )

        val jobTitle = ValidatorSingUp.validateJobTitle(
            userJobTitle = registrationUIState.value.jobTitle
        )

        val emailResult = ValidatorSingUp.validateEmail(
            email = registrationUIState.value.email
        )

        val passwordResult = ValidatorSingUp.validatePassword(
            password = registrationUIState.value.password
        )
        val positionResult = ValidatorSingUp.validatePosition(
            position = registrationUIState.value.position
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "fNameResult= $userName")
        Log.d(TAG, "lNameResult= $jobTitle")
        Log.d(TAG, "emailResult= $emailResult")
        Log.d(TAG, "passwordResult= $passwordResult")
        Log.d(TAG, "positionResult= $positionResult")


        registrationUIState.value = registrationUIState.value.copy(
            userNameValidate = userName.status,
            jobTitleValidate = jobTitle.status,
            emailValidate = emailResult.status,
            passwordValidate = passwordResult.status,
            positionValidate = positionResult.status
        )


        allValidationsPassed.value = userName.status && jobTitle.status &&
                emailResult.status && passwordResult.status && positionResult.status
        registrationUIState.value.buttonRegisteration =  allValidationsPassed.value

    }

    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
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
        val userData = hashMapOf(
            "data" to createCaption(),
            "email" to email,
            "idCreator" to AppSession.keyUserSession,
            "jobTitle" to jobTitle,
            "key" to key,
            "userName" to userName,
            "password" to password,
            "position" to position
        )

        Log.i(TAG, "signUpInProgress")

        FirebaseDatabase.getInstance().getReference("user_employee")
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

    }
}

private fun createCaption(): String =
    DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()

private fun createKey(): String = Random.nextInt(0, 9999).toString()

