package com.example.elitefacade.ui.screen


/*object UserPreferences {
    private const val USER_PREFERENCES_NAME = "user_preferences"

    val Context.dataStore: DataStore<User> by protoDataStore(
        fileName = USER_PREFERENCES_NAME,
        serializer = UserSerializer
    )

    val Context.userPreferencesFlow: Flow<User>
        get() = dataStore.data
            .catch { exception ->
                if (exception is InvalidProtocolBufferException) {
                    emit(User.getDefaultInstance())
                } else {
                    throw exception
                }
            }

    suspend fun updateDataStore(user: User) {
        context.dataStore.updateData { currentUser ->
            currentUser.toBuilder()
                .setData(user.data)
                .setEmail(user.email)
                .setIdCreator(user.idCreator)
                .setJobTitle(user.jobTitle)
                .setKey(user.key)
                .setUserName(user.userName)
                .setPassword(user.password)
                .setPosition(user.position)
                .build()
        }
    }
}*/

