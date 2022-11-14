package com.gzq.wanandroid.features.free_style

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.core.quality.LogCompositions
import com.gzq.wanandroid.core.quality.recomposeHighlighter
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.MyTopAppBar
import timber.log.Timber

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.freeStylePage(
    navController: NavHostController
) {
    composable(Router.FreeStylePage.route) {
        FreeStylePage(clickBack = {
            navController.popBackStack()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeStylePage(
    viewModel: FreeStyleViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    clickBack: () -> Unit
) {
    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(titleStr = "自由项目", clickBack = clickBack)
        }) { paddingValues ->
            Column(
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .recomposeHighlighter()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                val counter = rememberSaveable { mutableStateOf(0) }
                CounterDemo(counter)
                Spacer(modifier = Modifier.height(20.dp))
                ShadowDemo()
                Spacer(modifier = Modifier.height(20.dp))
                AnimationVisibility()
                Spacer(modifier = Modifier.height(20.dp))
                AnimationColor()
                Spacer(modifier = Modifier.height(20.dp))
                EffectDemo { viewModel.testFunc() }
                Spacer(modifier = Modifier.height(20.dp))
                AnimateFloatDemo()
            }
        }
    }
}

@Composable
fun CounterDemo(counter: MutableState<Int>) {
    Text(text = "counter:${counter.value}")
    Button(onClick = { counter.value += 1 }) {
        Text(text = "增加数值")
    }
}

@Composable
fun ShadowDemo() {
    Text(
        text = "我是正经文字\n111111",
        Modifier
            .width(200.dp)
            .shadow(3.dp, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Red)
            .clickable {

            }
            .padding(horizontal = 6.dp, vertical = 10.dp),
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AnimationVisibility() {
    var visibility by remember {
        mutableStateOf(false)
    }
    LogCompositions(msg = "AnimationVisibility")
    AnimatedVisibility(visible = visibility) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        ) {

        }
    }
    Button(onClick = { visibility = !visibility }) {
        Text(text = if (visibility) "隐藏方块" else "显示方块")
    }
}

@Composable
fun AnimationColor() {
    LogCompositions(msg = "AnimationColor")
    var changeColor by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(targetValue = if (changeColor) Color.Red else Color.Green)
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
    ) {

    }
    Button(onClick = { changeColor = !changeColor }) {
        Text(text = "改变颜色")
    }
}

@Composable
fun EffectDemo(testFunc: suspend () -> Unit) {
    var counter by remember {
        mutableStateOf(0)
    }
    LogCompositions(msg = "Effect")

    SideEffect {
        Timber.tag("Effect").d("SideEffect执行了")
    }

    //key1传Unit或者true，首次渲染执行一次
    DisposableEffect(Unit) {
        Timber.tag("Effect").d("DisposableEffect执行了")
        onDispose {

        }
    }
    LaunchedEffect(Unit) {
        Timber.tag("Effect").d("LaunchedEffect执行了")
        testFunc()
    }
    Text(text = "测试Effect：$counter")
    Button(onClick = {
        counter += 1
    }) {
        Text(text = "触发重组")
    }
}

@Composable
fun AnimateFloatDemo() {
    var enabled by remember {
        mutableStateOf(true)
    }
    //动画改变 Box 透明度
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f)
    Box(
        Modifier
            .size(100.dp)
            .graphicsLayer(alpha = alpha)
            .background(Color.Red)
            .recomposeHighlighter()
    )
    Button(onClick = { enabled = !enabled }) {
        Text(text = "改变透明度")
    }
}