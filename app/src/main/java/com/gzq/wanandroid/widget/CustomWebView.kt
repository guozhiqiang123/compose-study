package com.gzq.wanandroid.widget

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.gzq.wanandroid.core.log.TAG_WEBVIEW
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient
import timber.log.Timber

enum class WebViewPageState {
    Start, Finish, Error
}

@Stable
sealed class WebViewEvent {
    data class ReceivedTitle(val title: String? = "") : WebViewEvent()
    data class ProgressChange(val progress: Int) : WebViewEvent()
    data class PageState(val state: WebViewPageState) : WebViewEvent()
}

class CustomWebChromeClient(private val onEvent: ((WebViewEvent) -> Unit)? = null) :
    WebChromeClient() {
    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
        onEvent?.invoke(WebViewEvent.ReceivedTitle(title))
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        onEvent?.invoke(WebViewEvent.ProgressChange(newProgress))
    }
}

class CustomWebViewClient(private val onEvent: ((WebViewEvent) -> Unit)? = null) : WebViewClient() {
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        onEvent?.invoke(WebViewEvent.PageState(WebViewPageState.Start))
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onEvent?.invoke(WebViewEvent.PageState(WebViewPageState.Finish))
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        onEvent?.invoke(WebViewEvent.PageState(WebViewPageState.Error))
    }

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        Timber.tag(TAG_WEBVIEW).d("url:${request.url},method:${request.method}")
        if (shouldOverrideUrlByApp(view, request.url.toString())) return true
        return super.shouldOverrideUrlLoading(view, request)
    }

    private fun shouldOverrideUrlByApp(view: WebView, url: String): Boolean {
        if (url.startsWith("http") || url.startsWith("ftp")) return false
        try {
            Intent.parseUri(url, Intent.URI_INTENT_SCHEME).also {
                (view.context as Activity).startActivity(it)
            }
        } catch (e: Exception) {
            Timber.tag(TAG_WEBVIEW).e(e)
            if (e is ActivityNotFoundException) {
                Toast.makeText(view.context, "未安装APP", Toast.LENGTH_SHORT).show()
            }
            return false
        }
        return true
    }
}

@Composable
fun CustomWebView(
    url: String,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    clickBack: (Boolean) -> Unit,
    onEvent: ((WebViewEvent) -> Unit)? = null
) {
    var agentWeb by remember { mutableStateOf<AgentWeb?>(null) }

    val indicatorColor = MaterialTheme.colorScheme.primary.toArgb()

    BackHandler {
        clickBack(agentWeb?.back() == false)
    }
    AndroidView(factory = {
        Timber.tag(TAG_WEBVIEW).d("初始化容器")
        val container = LinearLayout(it)
        agentWeb = AgentWeb.with((it) as Activity)
            .setAgentWebParent(container, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator(indicatorColor)
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .setWebChromeClient(CustomWebChromeClient(onEvent))
            .setWebViewClient(CustomWebViewClient(onEvent))
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)
            .createAgentWeb()
            .ready()
            .go(url)
        //开启网页暗黑
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(
                agentWeb!!.agentWebSettings.webSettings,
                if (isDarkTheme) WebSettingsCompat.FORCE_DARK_ON
                else WebSettingsCompat.FORCE_DARK_OFF
            )
        }
        container
    }, modifier = modifier)

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(Unit) {
        val observer = object : DefaultLifecycleObserver {

            override fun onPause(owner: LifecycleOwner) {
                Timber.tag(TAG_WEBVIEW).d("生命周期：onPause")
                agentWeb?.webLifeCycle!!.onPause()
            }

            override fun onResume(owner: LifecycleOwner) {
                Timber.tag(TAG_WEBVIEW).d("生命周期：onResume")
                agentWeb?.webLifeCycle!!.onResume()
            }

            //注释的代码是反例
            //因为使用的LocalLifecycleOwner.current实际是MainActivity的，
            // 所以退出Compose当前页，并不会执行onDestroy
//            override fun onDestroy(owner: LifecycleOwner) {
//                Timber.tag(TAG_WEBVIEW).d("生命周期：onDestroy")
//                agentWeb?.webLifeCycle!!.onDestroy()
//            }
        }
        Timber.tag(TAG_WEBVIEW).d("开始监听")
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            Timber.tag(TAG_WEBVIEW).d("结束监听")
            lifecycleOwner.lifecycle.removeObserver(observer)
            //在退出Compose页面的时候释放webview
            agentWeb?.webLifeCycle!!.onDestroy()
        }
    }

}