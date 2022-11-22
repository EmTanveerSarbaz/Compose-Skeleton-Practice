package com.tanveer.test.composeskeletonpractice.shared.data.repository.api

import com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.data.UserDetailsEntity
import com.tanveer.test.composeskeletonpractice.screens_pre_login.screen_splash.business.UserEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    suspend fun getUserList(): List<UserEntity>

    @GET("userDetails")
    suspend fun getUserDetails(@Query("userId") userId: String): UserDetailsEntity
}