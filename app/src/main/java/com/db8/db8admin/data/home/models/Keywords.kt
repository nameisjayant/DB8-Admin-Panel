package com.db8.db8admin.data.home.models

import androidx.annotation.DrawableRes
import com.db8.db8admin.R

data class Keywords(
    @DrawableRes val postImage: Int,
    val username: String,
    @DrawableRes val userImage: Int,
    val approve: String,
    @DrawableRes val approveImage: Int,
    val keyword: String,
    val postDescription: String
)


val keywordList = listOf(
    Keywords(
        R.drawable.post,
        "Smita Roy",
        R.drawable.user_image,
        "Approved",
        R.drawable.green,
        "Modi",
        "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain."
    ),
    Keywords(
        R.drawable.post, "Smita Roy",
        R.drawable.user_image,
        "Decline",
        R.drawable.red,
        "Cricket",
        "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain."
    ),
    Keywords(
        R.drawable.post,
        "Smita Roy",
        R.drawable.user_image,
        "Approved",
        R.drawable.green,
        "TATA",
        "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain."
    ),
    Keywords(
        R.drawable.post,
        "Smita Roy",
        R.drawable.user_image,
        "Decline",
        R.drawable.red,
        "BJP",
        "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain."
    ),
    Keywords(
        R.drawable.post,
        "Smita Roy",
        R.drawable.user_image,
        "Approved",
        R.drawable.green,
        "Election",
        "The coronavirus situation in Delhi is under control and the city is expected to report less than 5,000 cases of the infection today, said city health minister Satyendar Jain."
    ),

    )

