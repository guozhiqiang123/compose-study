package com.gzq.wanandroid.features.test_click

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.MyTopAppBar
import kotlin.math.roundToInt

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.testClickPage(
    navController: NavHostController
) {
    composable(Router.TestClickPage.route) {
        ClickEventTest()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestClickPage(clickBack: () -> Unit) {
    Scaffold(topBar = {
        MyTopAppBar(title = "测试点击穿透", clickBack = clickBack)
    }) { paddingValues ->
        val ctx = LocalContext.current
        Box(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Button(onClick = {
                Toast.makeText(ctx, "点击生效", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "点击我")
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

            }
        }
    }
}

@Composable
fun ClickEventTest() {
    val ctx = LocalContext.current
    var offset by remember {
        mutableStateOf(0f)
    }
    Box(Modifier.fillMaxSize()) {
        Button(
            onClick = { Toast.makeText(ctx, "我是Toast", Toast.LENGTH_SHORT).show() },
        ) {
            Text(text = "点我")
        }
        Column(
            Modifier
                .fillMaxSize()
                .offset { IntOffset(0, offset.roundToInt()) }
                .draggable(rememberDraggableState(onDelta = { offset += it }), Orientation.Vertical)
        ) {
            repeat(20) { i ->
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Red)
                )
            }
        }
    }
}