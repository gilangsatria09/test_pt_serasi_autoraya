package com.example.test_pt_serasi_autoraya.ui.views.mainactivity

import com.example.test_pt_serasi_autoraya.navigations.Navigation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test_pt_serasi_autoraya.R
import com.example.test_pt_serasi_autoraya.core.values.AppColors
import com.example.test_pt_serasi_autoraya.core.values.DefaultAppTheme
import com.example.test_pt_serasi_autoraya.navigations.View
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultAppTheme {
                val navController = rememberNavController()
                Navigation(navController = navController, modifier = Modifier.padding())
            }
        }
    }
}

@Composable
fun AppSplashScreenView(navController: NavController) {
    val mainViewModel = hiltViewModel<MainActivityViewModel>()

    LaunchedEffect(key1 = true, block = {
        delay(1000)
        navController.navigate(View.Home.route) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    })


    DefaultAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = AppColors.Apricot,
                )
        ) {
                Image(
                    painter = painterResource(id = R.drawable.movies_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredWidth(250.dp)
                        .align(
                            Alignment.Center
                        )
                )

        }
    }
}

