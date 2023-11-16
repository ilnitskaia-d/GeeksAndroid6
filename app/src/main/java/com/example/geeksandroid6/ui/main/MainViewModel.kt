package com.example.geeksandroid6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geeksandroid6.data.model.Item
import com.example.geeksandroid6.data.model.PlaylistItem
import com.example.geeksandroid6.data.repo.YouTubeRepo
import org.koin.java.KoinJavaComponent.inject

class MainViewModel(
    private val repo: YouTubeRepo
): ViewModel() {

    fun getPlaylist(): LiveData<List<Item>> {
        return repo.getPlaylists()
    }

    fun getVideos(playlistId: String): LiveData<List<PlaylistItem>> {
        return repo.getVideos(playlistId)
    }
}