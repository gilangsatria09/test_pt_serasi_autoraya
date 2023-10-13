package com.example.test_pt_serasi_autoraya.network

import DetailMovieModel
import com.example.test_pt_serasi_autoraya.core.base.BasePaginationModel
import com.example.test_pt_serasi_autoraya.data.models.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): BasePaginationModel<MovieModel>
    @GET("movie/{movieId}")
    suspend fun getDetailMovie(
        @Path("movieId") movieId: Int
    ): DetailMovieModel
}