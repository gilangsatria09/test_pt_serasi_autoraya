package com.example.test_pt_serasi_autoraya.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.example.test_pt_serasi_autoraya.core.values.AppColors

@Composable
fun DefaultAppBar(title:String?,canBack:Boolean = false, onBackPressed : () -> Unit) {
    TopAppBar(backgroundColor = AppColors.Apricot,) {
        Row {
            Spacer(modifier = Modifier.width(10.dp))

            if (canBack) Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        onBackPressed()
                    }
            )

            if (canBack) Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = title ?: "",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}