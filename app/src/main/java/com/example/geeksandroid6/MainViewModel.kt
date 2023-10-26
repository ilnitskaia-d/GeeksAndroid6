package com.example.geeksandroid6

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val repo = RickAndMortyRepo()
    private val _charactersData = MutableLiveData<List<Character>>()
    val charactersData : LiveData<List<Character>> = _charactersData

    fun getCharacters() {
        _charactersData.value = repo.getCharacters()
    }

    fun getAdapter(onClick: (model: Character) -> Unit): ModelAdapter {
        return ModelAdapter(charactersData.value, onClick)
    }

}