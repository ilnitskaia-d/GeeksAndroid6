package com.example.geeksandroid6.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.geeksandroid6.App
import com.example.geeksandroid6.BuildConfig
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.data.model.BaseResponse
import com.example.geeksandroid6.data.model.Item
import com.example.geeksandroid6.data.model.PlaylistItem
import com.example.geeksandroid6.data.model.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YouTubeRepo(
    private val api: YouTubeApiService
) {

    fun getPlaylists() : LiveData<List<Item>> = liveData(Dispatchers.IO) {
        val response = api.getPlaylists(
            "AIzaSyCyJjiCHO9ivu3DTlgvOQVhmcbq0czluq4",
            "UCkxZg2ueb8OYjbDUJiB6wrw",
            "snippet, contentDetails",
        30
        )
        emit(response.body()!!.items)
    }

    private suspend fun getPlaylistItem(playlistId: String) : List<PlaylistItem> {
        val response = api.getPlaylistItem(
            "AIzaSyCyJjiCHO9ivu3DTlgvOQVhmcbq0czluq4",
            playlistId,
            "snippet, contentDetails",
            30
        )

        return (response.body()!!.items)
    }

    fun getVideos(playlistId: String) : LiveData<List<Video>> = liveData(Dispatchers.IO){
        val playlistItems = getPlaylistItem(playlistId)

        var ids = ""

        for (item: PlaylistItem in playlistItems)
            ids += "," + item.contentDetails.videoId

        val response = api.getVideos(
            "AIzaSyCyJjiCHO9ivu3DTlgvOQVhmcbq0czluq4",
            ids,
            "snippet, contentDetails",
            5
        )
        Log.e("mist", response.body()?.items?.size.toString())
        emit(response.body()!!.items)
    }
}