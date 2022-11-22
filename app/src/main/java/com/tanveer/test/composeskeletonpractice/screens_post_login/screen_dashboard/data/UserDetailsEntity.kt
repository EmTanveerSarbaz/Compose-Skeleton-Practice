package com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.data

data class UserDetailsEntity(
    val title: String,
    val description: String,
    val full_description: String,
    val price: Double,
    val imageUrl : String,
    val pros : List<String>,
    val cons : List<String>
)