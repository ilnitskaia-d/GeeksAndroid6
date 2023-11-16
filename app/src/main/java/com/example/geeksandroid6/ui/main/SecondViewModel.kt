package com.example.geeksandroid6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geeksandroid6.data.model.Item
import com.example.geeksandroid6.data.model.PlaylistItem
import com.example.geeksandroid6.data.model.Video
import com.example.geeksandroid6.data.repo.YouTubeRepo
import org.koin.java.KoinJavaComponent.inject

class SecondViewModel(
    private val repo: YouTubeRepo
): ViewModel() {

    fun getVideos(playlistId: String): LiveData<List<Video>> {
        return repo.getVideos(playlistId)
    }
}