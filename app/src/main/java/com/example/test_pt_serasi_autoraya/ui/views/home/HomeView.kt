package com.example.test_pt_serasi_autoraya.ui.views.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test_pt_serasi_autoraya.ui.components.DefaultAppBar
import com.example.test_pt_serasi_autoraya.ui.components.MovieItemList

@Composable
fun HomeView(navController:NavController) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState, topBar = {
        DefaultAppBar(title = "Home",canBack = navController.previousBackStackEntry != null) {
            
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            MovieItemList(navController = navController, movies = homeViewModel.popularMovies)
        }
    }
}