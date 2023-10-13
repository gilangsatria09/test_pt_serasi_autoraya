package com.example.test_pt_serasi_autoraya.ui.components

import AppApiUrl
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.test_pt_serasi_autoraya.core.utils.conditional
import com.example.test_pt_serasi_autoraya.core.utils.items
import com.example.test_pt_serasi_autoraya.core.utils.pagingLoadingState
import com.example.test_pt_serasi_autoraya.core.values.AppColors
import com.example.test_pt_serasi_autoraya.data.models.MovieModel
import com.example.test_pt_serasi_autoraya.navigations.View
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import kotlinx.coroutines.flow.Flow

@Composable
fun MovieItemList(
    navController: NavController,
    movies: Flow<PagingData<MovieModel>>
) {
    val moviesItems: LazyPagingItems<MovieModel> = movies.collectAsLazyPagingItems()
    val showProgressBar = remember {
        mutableStateOf(false)
    }

    if(showProgressBar.value) {
        CustomCircularProgressBar()
    }
    Column(modifier = Modifier.background(Color.White)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 8.dp),
            content = {
                items(moviesItems) { item ->
                    item?.let {
                        MovieItemComponent(item, navController)
                    }
                }
            })
    }

    moviesItems.pagingLoadingState {
        showProgressBar.value = it
    }
}

@Composable
fun MovieItemComponent(movieModel: MovieModel, navController: NavController) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, top = 0.dp, bottom = 10.dp)
            .clickable {
                navController.navigate(View.MovieDetail.route.plus("/${movieModel.id}"))
            }
            .height(IntrinsicSize.Max),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CoilImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                imageModel = {
                    AppApiUrl.IMAGE_URL.plus(movieModel.posterPath)
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    contentDescription = "Movie item",
                )
            ) {

            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(movieModel.title, fontSize = 16.sp, fontWeight = FontWeight.Bold, maxLines = 1,overflow = TextOverflow.Ellipsis)
                Text(movieModel.overview, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp), maxLines = 2,overflow = TextOverflow.Ellipsis)
            }
        }
    }
}
