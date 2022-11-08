package com.gzq.wanandroid.core.glide

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 * 自定义全局Glide实例，请使用GlideApp.with()代替Glide.with()
 */
@GlideModule
class WanandroidGlideModule : AppGlideModule() {
    //1、新版本Glide不再需要配置AndroidManifest
    //2、同时为了解决使用Glide页面不能预览的问题
    override fun isManifestParsingEnabled(): Boolean = false
}