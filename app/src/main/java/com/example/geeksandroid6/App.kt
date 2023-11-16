package com.example.geeksandroid6

import android.app.Application
import okhttp3.OkHttpClient
import com.example.geeksandroid6.BuildConfig.BASE_URL
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.di.youTubeModule
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(youTubeModule)
        }

    }
}