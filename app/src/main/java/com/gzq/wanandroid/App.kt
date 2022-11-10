package com.gzq.wanandroid

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.github.panpf.sketch.Sketch
import com.github.panpf.sketch.SketchFactory
import com.github.panpf.sketch.decode.SvgBitmapDecoder
import com.gzq.wanandroid.net.NetHelper
import com.tencent.mmkv.MMKV
import com.gzq.wanandroid.core.log.CrashReportingTree
import timber.log.Timber

class App : Application(), SketchFactory {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        //初始化日志库
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashReportingTree())

        MMKV.initialize(this)

        //初始网络工具类
        NetHelper.init(this)

    }

    /**
     * Sketch支持图片加载，组件注册
     */
    override fun createSketch(): Sketch {
        return Sketch.Builder(this).apply {
            components {
                addBitmapDecoder(SvgBitmapDecoder.Factory())
            }
        }.build()
    }
}