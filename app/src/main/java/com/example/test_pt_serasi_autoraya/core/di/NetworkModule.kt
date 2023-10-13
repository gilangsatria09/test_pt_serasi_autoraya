package com.example.test_pt_serasi_autoraya.core.di

import AppApiUrl
import com.example.test_pt_serasi_autoraya.network.interceptors.MoviesRequestInterceptor
import com.example.test_pt_serasi_autoraya.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideBaseUrl():String {
        return AppApiUrl.BASE_URL
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient().newBuilder()
            .callTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(MoviesRequestInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideContentType():MediaType {
        return "application/json".toMediaType()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(contentType:MediaType) : Converter.Factory {
        return Json.asConverterFactory(contentType)
    }

    @Singleton
    @Provides
    fun provideRetrofitClient(
        baseUrl:String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

}