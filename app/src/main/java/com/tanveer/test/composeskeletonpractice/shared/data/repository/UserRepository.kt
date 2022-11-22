package com.tanveer.test.composeskeletonpractice.shared.data.repository

import com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.business.UserDetails
import com.tanveer.test.composeskeletonpractice.screens_pre_login.screen_splash.data.User

interface UserRepository {

    suspend fun getUserList(): List<User>

    suspend fun getUserDetails(userId: String): UserDetails
}