package com.example.geeksandroid6.data.repo

import android.util.Log
import com.example.geeksandroid6.App
import com.example.geeksandroid6.BuildConfig
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.data.model.BaseResponse
import com.example.geeksandroid6.data.model.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class YouTubeRepo @Inject constructor(
    private val api: YouTubeApiService
) {

    fun getPlaylists(): List<Item> {
        val request = api.getPlaylists(
            "AIzaSyCyJjiCHO9ivu3DTlgvOQVhmcbq0czluq4",
            "UCkxZg2ueb8OYjbDUJiB6wrw",
            "snippet, contentDetails",
        30
        )

        var playlist = listOf<Item>()

        request.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    playlist = response.body()!!.items
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.e("getPlaylists", "onFailure: ${t.localizedMessage}")
            }
        })
        Log.e("mist", playlist.size.toString())
        return playlist
    }
}