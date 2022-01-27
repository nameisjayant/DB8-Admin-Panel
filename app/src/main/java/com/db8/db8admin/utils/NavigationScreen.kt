package com.db8.db8admin.utils

import com.db8.db8admin.R

sealed class NavigationScreen(val title: String, val route: String, val icon: Int) {


    object UserManagement :
        NavigationScreen("User Management", "usermanagement", R.drawable.user_management)
    object PostApproval :
        NavigationScreen("Post Approval", "postapproval", R.drawable.post_approval)
    object KeywordApproval :
        NavigationScreen("keyword Approval", "keywordapproval", R.drawable.keyword_approval)

    object Profile : NavigationScreen("Profile Settings", "profile", R.drawable.profile)

}
