package com.example.geeksandroid6

class RickAndMortyRepo {

    fun getCharacters(): List<Character> {
        val response = App().apiService.getCharacters()
        var result = listOf<Character>()
        if (response.isSuccessful && response.body() != null) {
            result = response.body()!!
        }
        return result
    }
}