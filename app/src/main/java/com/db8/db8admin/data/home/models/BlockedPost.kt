package com.db8.db8admin.data.home.models

data class BlockedPost(
    val status:String?,
    val data:List<Data?>
){
    data class Data(
        val POST_ID:String?,
        val POST_DATETIME:String?,
        val USERNAME:String?,
        val POST_CONTENT:String?,
        val EMBEDDED_CONTENT:String?
    )

    data class BlockedPostRequest(
        val from:String,
        val to:String,
        val tid:String
    )
}