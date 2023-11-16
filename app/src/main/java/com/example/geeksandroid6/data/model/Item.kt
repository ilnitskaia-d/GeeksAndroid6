package com.example.geeksandroid6.data.model

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)