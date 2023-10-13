package com.example.test_pt_serasi_autoraya.ui.views.moviedetail

import DetailMovieModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.test_pt_serasi_autoraya.data.repositories.MovieRepository
import com.example.test_pt_serasi_autoraya.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    val movieDetail : MutableState<DataState<DetailMovieModel>?> = mutableStateOf(null)

    fun getDetailMovie(movieId:Int) {
        viewModelScope.launch {
            repository.getMovieDetail(movieId).onEach {
                movieDetail.value = it
            }.launchIn(viewModelScope)
        }
    }
}