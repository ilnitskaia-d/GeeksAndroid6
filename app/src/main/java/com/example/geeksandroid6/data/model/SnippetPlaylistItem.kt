package com.example.geeksandroid6.data.model

data class SnippetPlaylistItem(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val playlistId: String,
    val thumbnails: ThumbnailsPlaylistItem,
    val title: String
)