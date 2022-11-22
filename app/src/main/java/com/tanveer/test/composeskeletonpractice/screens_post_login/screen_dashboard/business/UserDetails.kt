package com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.business

data class UserDetails(
    val title: String,
    val description: String,
    val fullDescription: String,
    val price: String,
    val imageUrl : String,
    val pros : List<String>,
    val cons : List<String>
)