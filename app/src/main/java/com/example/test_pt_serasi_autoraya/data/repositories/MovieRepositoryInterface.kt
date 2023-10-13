package com.example.test_pt_serasi_autoraya.data.repositories

import DetailMovieModel
import androidx.paging.PagingData
import com.example.test_pt_serasi_autoraya.data.models.MovieModel
import com.example.test_pt_serasi_autoraya.network.DataState
import kotlinx.coroutines.flow.Flow

interface MovieRepositoryInterface {
    suspend fun getMovieDetail(movieId:Int): Flow<DataState<DetailMovieModel>>

    fun getPopularMovie() : Flow<PagingData<MovieModel>>
}