package com.example.elitefacade.data

import android.util.Log
import com.example.elitefacade.domain.LoginResultCallback
import com.example.elitefacade.domain.UserRepository
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIState
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.CLIENT
import com.example.elitefacade.ui.screen.Registration.PegistrationViewModel.EMPLOYEE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor() : UserRepository {
    private val TAG = UserRepository::class.simpleName
    override fun saveUserDataInFireBase(user: User) {
        when (user.position) {
            EMPLOYEE -> FirebaseDatabase.getInstance().getReference("user_employee")
                .child(user.key)//.child(uid)
                .setValue(user)
                .addOnSuccessListener {
                    Log.d(TAG, "User data successfully written!")
                    // Пользователь успешно создан и данные сохранены в Realtime Database
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error writing document", e)
                    // Ошибка при сохранении данных в Realtime Database
                }

            CLIENT -> FirebaseDatabase.getInstance().getReference("user_client")
                .child(user.key)//.child(uid)
                .setValue(user)
                .addOnSuccessListener {
                    Log.d(TAG, "User data successfully written!")
                    // Пользователь успешно создан и данные сохранены в Realtime Database
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error writing document", e)
                    // Ошибка при сохранении данных в Realtime Database
                }

            else -> Log.e(TAG, "Ошибка в createUserInFirebase")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun loginUserInFireBase(loginUser: LoginUIState, callback: LoginResultCallback) {

        val database = FirebaseDatabase.getInstance()
        val referenceEmployee = database.getReference("user_employee")
        val referenceClient = database.getReference("user_client")

        when (loginUser.position) {
            EMPLOYEE -> referenceEmployee.addListenerForSingleValueEvent(object :
                ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    for (snapshot in dataSnapshot.children) {
                        val userData = snapshot.getValue(User::class.java)
                        if (userData != null &&
                            userData.userName == loginUser.userName &&
                            userData.password == loginUser.password
                        ) { // Найден пользователь с заданным именем пользователя и паролем
                            Log.i(
                                TAG,
                                "В fireBase найден введённый пользователь: $loginUser.userName"
                            )
                            callback.onLoginSuccess(userData)
                            return
                        } else {
                            if (userData != null) {
                                Log.i(
                                    TAG,
                                    "Пользователь не найден или неверный пароль: ${userData.userName}"
                                )
                            }
                        }
                    }
                    callback.onLoginFailed()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Обработка ошибки при чтении данных
                    callback.onLoginFailed()
                    Log.e(TAG, "Error reading data", databaseError.toException())
                }
            })

            CLIENT -> referenceClient.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {
                        val userData = snapshot.getValue(User::class.java)
                        if (userData != null &&
                            userData.userName == loginUser.userName &&
                            userData.password == loginUser.password
                        ) {
                            // Найден пользователь с заданным именем пользователя и паролем
                            callback.onLoginSuccess(userData)
                            Log.i(TAG, "Успешный вход пользователя: $loginUser.userName")
                            return
                        } else {
                            if (userData != null) {
                                Log.i(
                                    TAG,
                                    "Пользователь не найден или неверный пароль:" +
                                            " ${userData.userName}"
                                )
                            }

                        }
                    }
                    callback.onLoginFailed()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Обработка ошибки при чтении данных
                    callback.onLoginFailed()
                    Log.e(TAG, "Error reading data", databaseError.toException())
                }
            })
        }
    }
}