package com.example.test_pt_serasi_autoraya.data.repositories

import DetailMovieModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.test_pt_serasi_autoraya.data.datasources.remote.paging.PopularMoviePagingDataSource
import com.example.test_pt_serasi_autoraya.data.models.MovieModel
import com.example.test_pt_serasi_autoraya.network.ApiService
import com.example.test_pt_serasi_autoraya.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) : MovieRepositoryInterface {
    override suspend fun getMovieDetail(movieId: Int): Flow<DataState<DetailMovieModel>> = flow {
        emit(DataState.Loading)
        try {
            val searchResult = apiService.getDetailMovie(movieId)
            emit(DataState.Success(searchResult))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    override fun getPopularMovie(): Flow<PagingData<MovieModel>> = Pager(
        pagingSourceFactory = {PopularMoviePagingDataSource(apiService)},
        config = PagingConfig(pageSize = 1)
    ).flow

}