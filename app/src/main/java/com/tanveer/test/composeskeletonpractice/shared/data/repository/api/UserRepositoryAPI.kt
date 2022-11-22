package com.tanveer.test.composeskeletonpractice.shared.data.repository.api

import com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.business.UserDetails
import com.tanveer.test.composeskeletonpractice.shared.data.repository.UserRepository
import com.tanveer.test.composeskeletonpractice.screens_pre_login.screen_splash.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryAPI  @Inject constructor(private val service: UserService) : UserRepository {

    override suspend fun getUserList(): List<User> {
        return withContext(Dispatchers.IO) {
            service.getUserList().map {
                User(
                    it.title,
                    it.description,
                    it.price,
                    it.imageUrl
                )
            }
        }
    }

    override suspend fun getUserDetails(userId: String): UserDetails {
        return withContext(Dispatchers.IO) {
            service.getUserDetails(userId).run {
                UserDetails(
                    this.title,
                    this.description,
                    this.full_description,
                    "US $ ${this.price}",
                    this.imageUrl,
                    this.pros,
                    this.cons
                )
            }
        }
    }
}