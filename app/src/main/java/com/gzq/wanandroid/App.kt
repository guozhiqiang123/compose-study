package com.gzq.wanandroid

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.github.panpf.sketch.Sketch
import com.github.panpf.sketch.SketchFactory
import com.github.panpf.sketch.decode.SvgBitmapDecoder
import com.gzq.wanandroid.core.log.CrashReportingTree
import com.gzq.wanandroid.repository.local.RoomHelp
import com.gzq.wanandroid.repository.remote.NetHelper
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.mmkv.MMKV
import com.yariksoffice.lingver.Lingver
import com.yariksoffice.lingver.store.PreferenceLocaleStore
import timber.log.Timber

class App : Application(), SketchFactory {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        appCtx = this
        //初始化日志库
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashReportingTree())

        MMKV.initialize(this)

        CrashReport.setIsDevelopmentDevice(this, BuildConfig.DEBUG)
        CrashReport.initCrashReport(this, Const.Bugly_App_Id, BuildConfig.DEBUG)

        //初始网络工具类
        NetHelper.init(this)

        //初始化数据库
        RoomHelp.init(this)

        //多语言
        val store = PreferenceLocaleStore(this)
        Lingver.init(this, store)
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

    companion object {
        lateinit var appCtx: App
    }
}