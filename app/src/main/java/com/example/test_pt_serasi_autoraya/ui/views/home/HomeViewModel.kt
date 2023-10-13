package com.example.test_pt_serasi_autoraya.ui.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.test_pt_serasi_autoraya.data.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    val popularMovies = repository.getPopularMovie().cachedIn(viewModelScope)
}