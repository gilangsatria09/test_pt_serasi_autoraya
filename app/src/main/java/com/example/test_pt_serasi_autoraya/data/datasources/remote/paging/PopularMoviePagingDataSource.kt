package com.example.test_pt_serasi_autoraya.data.datasources.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.test_pt_serasi_autoraya.data.models.MovieModel
import com.example.test_pt_serasi_autoraya.network.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PopularMoviePagingDataSource @Inject constructor(private val apiService: ApiService) :
    PagingSource<Int, MovieModel>() {
    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        return try {
            val nextPage = params.key ?: 1
            val movieList = apiService.getPopularMovies(nextPage)
            LoadResult.Page(
                data = movieList.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (movieList.results.isNotEmpty()) movieList.page + 1 else null
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (httpException: HttpException) {
            return LoadResult.Error(httpException)
        }
    }

}