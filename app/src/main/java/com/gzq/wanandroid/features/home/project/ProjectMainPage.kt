package com.gzq.wanandroid.features.home.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gzq.wanandroid.R
import com.gzq.wanandroid.exit_app.MyBackHandler


@Composable
fun ProjectMainPage(
    modifier: Modifier = Modifier,
    routeGlideImagePage: () -> Unit,
    routeCoilImagePage: () -> Unit,
    routeSketchImagePage: () -> Unit,
    routeFreeStylePage: () -> Unit,
    routeTestClickPage: () -> Unit,
) {
    MyBackHandler()
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Button(
                onClick = routeGlideImagePage,
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.glide_load_image))
            }
        }
        item {
            Button(
                onClick = routeCoilImagePage,
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.coil_load_image))
            }
        }
        item {
            Button(
                onClick = routeSketchImagePage,
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.sketch_load_image))
            }
        }
        item {
            Button(
                onClick = routeFreeStylePage,
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.free_style_projects))
            }
        }
        item {
            Button(
                onClick = routeTestClickPage,
                Modifier.fillMaxWidth()
            ) {
                Text(text = "验证点击事件穿透")
            }
        }
    }
}