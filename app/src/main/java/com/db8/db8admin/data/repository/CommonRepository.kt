package com.db8.db8admin.data.repository

import com.db8.db8admin.data.home.models.BlockedPost
import com.db8.db8admin.data.home.models.KeywordRequest
import com.db8.db8admin.network.ApiService
import com.db8.db8admin.utils.toResultFlow
import javax.inject.Inject

class CommonRepository @Inject constructor(private val apiService: ApiService) {

    fun getAllKeywords() = toResultFlow {
        apiService.getAllKeywords(
            "57P79st3f8uNaG359hB2109vwIE0lx2k",
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1dWlkIjoiMTI3MTQ5ODUtOThkNC0xMWVhLWFlYWItMDY1NDNjNDhiYTA5IiwidXNlcm5hbWUiOiJ3ZXJ0eXUiLCJjb3VudHJ5X2NvZGUiOiJJTkQiLCJpYXQiOjE2MTM2MjU2MDksImV4cCI6MTYxNDgzNTIwOX0._mw01gUQcLeIGJyDVT1v9c8_2u7s6uKWk1Bdg4RREa8",
            KeywordRequest("1", "0", "30")
        )
    }

    fun getBlockedPosts() = toResultFlow {
        apiService.getAllBlockedPosts(
            "57P79st3f8uNaG359hB2109vwIE0lx2k",
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1dWlkIjoiMTI3MTQ5ODUtOThkNC0xMWVhLWFlYWItMDY1NDNjNDhiYTA5IiwidXNlcm5hbWUiOiJ3ZXJ0eXUiLCJjb3VudHJ5X2NvZGUiOiJJTkQiLCJpYXQiOjE2MTM2MjU2MDksImV4cCI6MTYxNDgzNTIwOX0._mw01gUQcLeIGJyDVT1v9c8_2u7s6uKWk1Bdg4RREa8",
            BlockedPost.BlockedPostRequest("0", "30", "1")
        )
    }
}