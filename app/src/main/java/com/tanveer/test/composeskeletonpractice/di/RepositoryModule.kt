package com.tanveer.test.composeskeletonpractice.di

import com.tanveer.test.composeskeletonpractice.shared.data.repository.api.ApiClient
import com.tanveer.test.composeskeletonpractice.shared.data.repository.api.UserRepositoryAPI
import com.tanveer.test.composeskeletonpractice.shared.data.repository.api.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesUserRepository(userRepositoryAPI: UserRepositoryAPI): UserRepositoryAPI = userRepositoryAPI

    @Provides
    fun providesUserRepositoryAPI(service: UserService): UserRepositoryAPI = UserRepositoryAPI(service)

    @Provides
    fun providesUserService(): UserService = ApiClient.getService()

}