package com.example.geeksandroid6.di

import com.example.geeksandroid6.BuildConfig
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.data.repo.YouTubeRepo
import com.example.geeksandroid6.ui.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val youTubeModule= module {
    //Client
    single { provideYouTubeApiService(get()) }
    single { provideRetrofitClient(get()) }
    single { provideOkHttpClient(get()) }
    single { provideLoggingInterceptor() }
    single { provideYouTubeRepo(get()) }
    //Repo
    single { YouTubeRepo(get()) }
    //viewModel
    viewModel { MainViewModel(get())}
}

fun provideYouTubeApiService(
    retrofit: Retrofit
) : YouTubeApiService = retrofit.create(YouTubeApiService::class.java)


fun provideRetrofitClient(
    okHttpClient: OkHttpClient
): Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .build()


fun provideOkHttpClient(
    interceptor: HttpLoggingInterceptor
) : OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .connectTimeout(10, TimeUnit.SECONDS)
    .build()


fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}


fun provideYouTubeRepo(
    apiService: YouTubeApiService
) = YouTubeRepo(apiService)