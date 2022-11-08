package com.gzq.wanandroid.widget

import android.app.Activity
import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.widget.LinearLayout
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
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient

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

    val indicatorColor =MaterialTheme.colorScheme.primary.toArgb()

    BackHandler {
        clickBack(agentWeb?.back() == false)
    }
    AndroidView(factory = {
        LinearLayout(it)
    }, modifier = modifier, update = {
        agentWeb = AgentWeb.with((it.context) as Activity)
            .setAgentWebParent(it, LinearLayout.LayoutParams(-1, -1))
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
    })

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(Unit) {
        val observer = object : DefaultLifecycleObserver {

            override fun onPause(owner: LifecycleOwner) {
                agentWeb?.webLifeCycle!!.onPause()
            }

            override fun onResume(owner: LifecycleOwner) {
                agentWeb?.webLifeCycle!!.onResume()
            }

            override fun onDestroy(owner: LifecycleOwner) {
                agentWeb?.webLifeCycle!!.onDestroy()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

}