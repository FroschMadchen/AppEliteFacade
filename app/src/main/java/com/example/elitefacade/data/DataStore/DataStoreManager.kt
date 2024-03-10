package com.example.elitefacade.data.DataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.elitefacade.domain.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class DataStoreManager @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_session")

        private val EMAIL_KEY =
            stringPreferencesKey("emailUser")
        private val ID_CREATOR_KEY =
            stringPreferencesKey("idCreatorUser")
        private val JOB_TITLE_KEY =
            stringPreferencesKey("jobTitleUser")
        private val ID_KEY =
            stringPreferencesKey("idUser")
        private val USER_NAME_KEY =
            stringPreferencesKey("userNameUser")
        private val PASSWORD_KEY =
            stringPreferencesKey("userNameUser")
        private val POSITION_KEY =
            stringPreferencesKey("userNameUser")
        private val DATA_KEY =
            stringPreferencesKey("dataUser")

    }

    suspend fun saveSessionUser(user: User) {
        context.dataStore.edit { prefs ->
            prefs[DATA_KEY] = user.data
            prefs[EMAIL_KEY] = user.email
            prefs[ID_CREATOR_KEY] = user.idCreator
            prefs[JOB_TITLE_KEY] = user.jobTitle
            prefs[ID_KEY] = user.key
            prefs[USER_NAME_KEY] = user.userName
            prefs[PASSWORD_KEY] = user.password
            prefs[POSITION_KEY] = user.position

        }
    }
    suspend fun deleteSessionUser(){
        context.dataStore.edit { prefs->
            prefs.remove(DATA_KEY)
            prefs.remove(EMAIL_KEY)
            prefs.remove(ID_CREATOR_KEY)
            prefs.remove(JOB_TITLE_KEY)
            prefs.remove(ID_KEY)
            prefs.remove(USER_NAME_KEY)
            prefs.remove(PASSWORD_KEY)
            prefs.remove(POSITION_KEY)
        }
    }

    fun getSessionUser() = runBlocking {// возможно без  runBlocking
        context.dataStore.data.map { prefs ->
        return@map User(
            prefs[DATA_KEY] ?: "дата создания",
            prefs[EMAIL_KEY] ?: "",
            prefs[ID_CREATOR_KEY] ?: "",
            prefs[JOB_TITLE_KEY] ?: "",
            prefs[ID_KEY] ?: "",
            prefs[USER_NAME_KEY] ?: "",
            prefs[PASSWORD_KEY] ?: "",
            prefs[POSITION_KEY] ?: ""
        )
    } }
}