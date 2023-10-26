package com.example.geeksandroid6

import java.io.Serializable

data class BaseResponse<T>(
     val results: List<T>
)

data class Character(
    val id: Int,
    val name: String,
    val image: String,
):Serializable
