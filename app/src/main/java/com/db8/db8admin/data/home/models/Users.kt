package com.db8.db8admin.data.home.models

import androidx.annotation.DrawableRes
import com.db8.db8admin.R

data class Users(
    val username: String,
    @DrawableRes val image: Int,
    @DrawableRes val active_image: Int,
    val active_des: String
)

val usersData = listOf(
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive"),
    Users("Smita Roy", R.drawable.user_image, R.drawable.red, "Inactive")
)
