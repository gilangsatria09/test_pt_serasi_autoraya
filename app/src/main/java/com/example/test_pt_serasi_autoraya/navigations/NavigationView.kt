package com.example.test_pt_serasi_autoraya.navigations

import androidx.annotation.StringRes
import com.example.test_pt_serasi_autoraya.R

sealed class View(
    val route: String,
    @StringRes val title: Int = R.string.placeholder,
    val objectName: String = "",
    val objectPath: String = ""
) {

    data object SplashScreen : View(route = "splash_screen")
    data object Home : View(route = "home_view")
    data object MovieDetail : View("movie_detail_view", objectName = "movieItem", objectPath = "/{movieItem}")
}
