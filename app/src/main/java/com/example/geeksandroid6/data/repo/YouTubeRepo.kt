package com.example.geeksandroid6.data.repo

import com.example.geeksandroid6.App
import com.example.geeksandroid6.BuildConfig
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.data.model.BaseResponse
import com.example.geeksandroid6.data.model.Item
import javax.inject.Inject

class YouTubeRepo @Inject constructor(
    private val api: YouTubeApiService
) {

    fun getPlaylists(): List<Item> {
        val response = api.getPlaylists(
            "",
            "",
            "snippet, contentDetails",
        30
        )
        var result = listOf<Item>()

        if (response.isSuccessful && response.body() != null) {
            result = response.body()!!.items
        }
    }

}