package com.example.geeksandroid6.data.model

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("etag")
    val etag: String,
    val items: List<Video>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)
