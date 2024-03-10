package com.example.elitefacade.di

import android.content.Context
import com.example.elitefacade.data.DataStore.DataStoreManager
import com.example.elitefacade.data.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    fun provideUserRepository(): UserRepositoryImpl {
        return UserRepositoryImpl()
    }
}

