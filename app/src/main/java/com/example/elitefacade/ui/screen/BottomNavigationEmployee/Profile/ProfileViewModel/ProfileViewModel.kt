package com.example.elitefacade.ui.screen.BottomNavigationEmployee.Profile.ProfileViewModel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elitefacade.data.DataStore.DataStoreManager
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager) : ViewModel() {

    private val tag = ProfileViewModel::class.simpleName
    private var _profileUserUiState = MutableStateFlow(User())
    val profileUserUiState = _profileUserUiState.asStateFlow()

    init {
        getUserDataSessionDataStore()
    }

    private fun getUserDataSessionDataStore(){
        viewModelScope.launch {
            dataStoreManager.getSessionUser()
                .stateIn(viewModelScope) // Преобразовать Flow<User> в MutableStateFlow<User>
                .collect { user ->
                    _profileUserUiState.value = user // Установить значение для MutableStateFlow
                    Log.i(tag,"${user.userName},${user.jobTitle} ")
                }
        }
    }

}