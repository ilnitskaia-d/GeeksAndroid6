package com.example.geeksandroid6

import android.app.Application
import okhttp3.OkHttpClient
import com.example.geeksandroid6.BuildConfig.BASE_URL
import com.example.geeksandroid6.data.client.YouTubeApiService
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App: Application()