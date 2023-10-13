package com.example.test_pt_serasi_autoraya.ui.views.moviedetail

import DetailMovieModel
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.test_pt_serasi_autoraya.core.utils.pagingLoadingState
import com.example.test_pt_serasi_autoraya.core.values.AppColors
import com.example.test_pt_serasi_autoraya.network.DataState
import com.example.test_pt_serasi_autoraya.ui.components.CustomCircularProgressBar
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieDetailView(navController: NavController,movieId:Int) {
    val movieDetailViewModel = hiltViewModel<MovieDetailViewModel>()
    val scrollController = rememberScrollState()
    val showProgressBar = remember {
        mutableStateOf(false)
    }
    val movieDetail = movieDetailViewModel.movieDetail

    LaunchedEffect(key1 = true, block = {
        movieDetailViewModel.getDetailMovie(movieId)
    })
    if(showProgressBar.value) {
        CustomCircularProgressBar()
    }

    movieDetail.value?.let {
        Log.d("Hai",it.toString())
        if(it is DataState.Success<DetailMovieModel>) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        CoilImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            imageModel = {
                                AppApiUrl.IMAGE_URL.plus(it.data.backdropPath)
                            },
                            imageOptions = ImageOptions(
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center,
                                contentDescription = "Backdrop",
                            )
                        )
                        Row(modifier = Modifier.padding(top = 150.dp, start = 28.dp)) {
                            CoilImage(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(170.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                imageModel = {
                                    AppApiUrl.IMAGE_URL.plus(it.data.posterPath)
                                },
                                imageOptions = ImageOptions(
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center,
                                    contentDescription = "Posters",
                                )
                            )
                            Column(modifier = Modifier.padding(top = 80.dp, start = 14.dp,end=14.dp)) {
                                Text(it.data.title,fontSize = 16.sp, fontWeight = FontWeight.Bold,)
                                Text(it.data.tagline,modifier = Modifier.padding(top = 2.dp))

                            }
                        }
                        Surface(
                            modifier = Modifier.padding(all = 10.dp),
                            color = Color.Transparent
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color.Black.copy(alpha = .5f),
                                        shape = CircleShape
                                    )
                                    .padding(all = 6.dp)
                            ) {
                                Image(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    colorFilter = ColorFilter.tint(Color.White),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .size(32.dp)
                                        .clickable {
                                            navController.popBackStack()
                                        }
                                )
                            }
                        }
                    }

                    Column(Modifier.padding(28.dp)) {
                        Text("Overview", fontSize = 16.sp,fontWeight = FontWeight.Bold)
                        Text(it.data.overview)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .background(AppColors.PastelRed)
                ) {
                    Text("Add To Favorite",modifier = Modifier.align(
                        Alignment.Center
                    ),fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }

    }

    movieDetail.pagingLoadingState {
        showProgressBar.value = it
    }
}