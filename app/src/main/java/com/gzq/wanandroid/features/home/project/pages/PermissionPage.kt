package com.gzq.wanandroid.features.home.project.pages

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.MyTopAppBar
import com.tencent.mmkv.MMKV

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.permissionPage(navController: NavHostController) {
    composable(Router.PermissionPage.route) {
        PermissionPage {
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionPage(clickBack: (() -> Unit)? = null) {
    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(title = "实验Coil加载图片功能", clickBack = clickBack ?: {})
        }) { paddingValue ->

            Column(
                Modifier
                    .padding(paddingValue)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val hasRequestCameraPermission = remember {
                    mutableStateOf(getLocalRequestCameraPermissionAction())
                }

                DisposableEffect(hasRequestCameraPermission.value) {
                    setLocalRequestCameraPermissionAction()
                    onDispose { }
                }

                requestPermissionUseLib(hasRequestCameraPermission)

                requestPermissionUseSystem(hasRequestCameraPermission)

            }
        }
    }
}

private fun getLocalRequestCameraPermissionAction(): Boolean {
    return MMKV.defaultMMKV().decodeBool(android.Manifest.permission.CAMERA, false)
}

private fun setLocalRequestCameraPermissionAction() {
    MMKV.defaultMMKV().encode(android.Manifest.permission.CAMERA, true)
}

/**
 * 使用支持compose的库
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun requestPermissionUseLib(hasRequest: MutableState<Boolean>) {
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )
    if (cameraPermissionState.status.isGranted) {
        Text("已获得相机权限")
        hasRequest.value = true
    } else {
        if (cameraPermissionState.status.shouldShowRationale) {
            Text(text = "您拒绝了本次权限申请")
            Button(onClick = {
                cameraPermissionState.launchPermissionRequest()
            }) {
                Text("请求-相机权限")
            }
            hasRequest.value = true
        } else {
            if (hasRequest.value) {
                Text(text = "您永久拒绝了相机权限，请前往权限设置页面开启")
                Button(onClick = {
                    //todo
                }) {
                    Text(text = "去权限设置页面")
                }
            } else {
                Button(onClick = {
                    cameraPermissionState.launchPermissionRequest()
                }) {
                    Text("请求-相机权限")
                }
            }
        }
    }
}

/**
 * 使用原生方式
 * 这个方式有问题，如果第一次拒绝，第二次永久拒绝，显示的文本信息不正确，因为两次isGranted值都为false，不会触发重组
 */
@Composable
fun requestPermissionUseSystem(hasRequest: MutableState<Boolean>) {
    val context = LocalContext.current

    var isGranted by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {
        isGranted = it
    }

    if (isGranted) {
        Text("已获得相机权限")
        hasRequest.value = true
    } else {
        val shouldShowRationale = shouldShowRequestPermissionRationale(
            context.findActivity(), android.Manifest.permission.CAMERA
        )
        if (shouldShowRationale) {
            Text(text = "您拒绝了本次权限申请")
            Button(onClick = {
                launcher.launch(android.Manifest.permission.CAMERA)
            }) {
                Text("请求-相机权限")
            }
            hasRequest.value = true
        } else {
            if (hasRequest.value) {
                Text(text = "您永久拒绝了相机权限，请前往权限设置页面开启")
                Button(onClick = {
                    //todo
                }) {
                    Text(text = "去权限设置页面")
                }
            } else {
                Button(onClick = {
                    launcher.launch(android.Manifest.permission.CAMERA)
                }) {
                    Text("请求-相机权限")
                }
            }
        }
    }
}

fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Permissions should be called in the context of an Activity")
}

