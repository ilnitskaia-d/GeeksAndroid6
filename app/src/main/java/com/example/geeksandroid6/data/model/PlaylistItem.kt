package com.example.geeksandroid6.data.model

data class PlaylistItem(
    val contentDetails: ContentDetailsPlaylistItem,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: SnippetPlaylistItem
)
