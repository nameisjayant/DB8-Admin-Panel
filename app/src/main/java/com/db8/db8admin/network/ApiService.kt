package com.db8.db8admin.network

import com.db8.db8admin.data.home.models.BlockedPost
import com.db8.db8admin.data.home.models.KeywordRequest
import com.db8.db8admin.data.home.models.KeywordResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    companion object{
        const val BASE_URL  = "http://dev2.opinito.com/api.dev/"
    }

    @POST("userKWScreening.php")
    suspend fun getAllKeywords(
        @Header("X-ACCESS-KEY") accessKey:String,
        @Header("TOKEN") token:String,
        @Body keywordRequest: KeywordRequest
    ):Response<KeywordResponse>


    @POST("blockedPostList.php")
    suspend fun getAllBlockedPosts(
        @Header("X-ACCESS-KEY") accessKey:String,
        @Header("TOKEN") token:String,
        @Body blockedPostRequest: BlockedPost.BlockedPostRequest
    ):Response<BlockedPost>

}