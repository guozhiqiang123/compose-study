package com.gzq.wanandroid.widget

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    backIcon: ImageVector = Icons.Default.ArrowBack,
    elevation: Dp = 4.dp,
    actions: @Composable RowScope.() -> Unit = {},
    clickBack: () -> Unit
) {

    Surface(elevation = elevation) {
        androidx.compose.material3.TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = clickBack) {
                    Icon(
                        imageVector = backIcon,
                        contentDescription = null,
                    )
                }
            },
            actions = actions,
            //因为TopBar默认高度是64dp，所以给减掉12dp，设置为52dp
            scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(
                state = rememberTopAppBarState().apply {
                    heightOffset = with(LocalDensity.current) { -12.dp.toPx() }
                })
        )
    }
}

@Preview
@Composable
fun MyTopAppBarPreview() {
    MyTopAppBar(title = "标题") {

    }
}