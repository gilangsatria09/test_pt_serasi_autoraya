package com.example.test_pt_serasi_autoraya.navigations

import android.window.SplashScreenView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.test_pt_serasi_autoraya.navigations.View
import com.example.test_pt_serasi_autoraya.ui.views.home.HomeView
import com.example.test_pt_serasi_autoraya.ui.views.mainactivity.AppSplashScreenView
import com.example.test_pt_serasi_autoraya.ui.views.moviedetail.MovieDetailView

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = View.SplashScreen.route,modifier = modifier) {
        composable(View.SplashScreen.route) {
            AppSplashScreenView(navController = navController)
        }
        composable(View.Home.route) {
            HomeView(navController)
        }
        composable(
            View.MovieDetail.route.plus(View.MovieDetail.objectPath),
            arguments = listOf(navArgument(View.MovieDetail.objectName) {
                type = NavType.IntType
            })
        ) {
            val movieId = it.arguments?.getInt(View.MovieDetail.objectName)
            movieId?.let {
                MovieDetailView(
                    navController = navController, movieId
                )
            }
        }
    }
}