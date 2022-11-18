package com.gzq.wanandroid.router

import com.gzq.wanandroid.features.open_source_libs.MarkdownPreviewPageArgs

/**
 * 如果需要传参，请参照DetailPage，单独提供方法，统一传参，方便维护
 */
sealed class Router(val route: String) {
    object HomePage : Router("home")
    object ProjectPage : Router("project")
    object ProfilePage : Router("profile")

    object GlideImagePage : Router("glide/image")
    object CoilImagePage : Router("coil/image")
    object SketchImagePage : Router("sketch/image")

    object DetailPage : Router("detail?{url}") {
        /**
         * 必须提供跳转链接
         * 因为网页链接不能作为DeepLink的必传参数，否则会报错，所以使用可传参数
         *
         * @param url 网页链接
         */
        fun createRoute(url: String): String = "detail?$url"
    }

    object LoginPage : Router("login")
    object RegisterPage : Router("register")
    object FreeStylePage : Router("free/style")
    object ChangeThemePage : Router("change/theme")
    object ChangeLanguagePage : Router("change/language")
    object MarkdownPreviewPage : Router("markdown?{args}") {
        //本打算在DeepLink中传递Parcelable对象，但是官方目前不支持
        //这是原文：https://issuetracker.google.com/issues/148523779
        fun createRoute(args: String): String = "markdown?$args"
    }
}
