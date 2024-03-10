package com.example.elitefacade.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.elitefacade.data.DataStore.DataStoreManager
import com.example.elitefacade.data.UserRepositoryImpl
import com.example.elitefacade.domain.UserRepository
import com.example.elitefacade.domain.model.User
import com.example.elitefacade.ui.screen.Login.LoginViewModel.LoginUIState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(dataStoreManager : DataStoreManager): UserRepositoryImpl {
        return UserRepositoryImpl(dataStoreManager)
    }

}

