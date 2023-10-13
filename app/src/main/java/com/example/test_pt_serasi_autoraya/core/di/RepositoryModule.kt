package com.example.test_pt_serasi_autoraya.core.di

import com.example.test_pt_serasi_autoraya.data.repositories.MovieRepository
import com.example.test_pt_serasi_autoraya.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: ApiService
    ):MovieRepository {
        return MovieRepository(apiService)
    }
}