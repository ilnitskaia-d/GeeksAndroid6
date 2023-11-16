package com.example.geeksandroid6.data.model

import com.google.gson.annotations.SerializedName

data class PlaylistResponse(
    @SerializedName("etag")
    val etag: String,
    val items: List<PlaylistItem>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)