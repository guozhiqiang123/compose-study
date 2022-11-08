package com.zlketang.it.core.log

import android.util.Log
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) return
        FakeCrashLibrary.log(priority, tag, message)
        if (priority == Log.ERROR) {
            FakeCrashLibrary.logError(message, t)
        } else if (priority == Log.WARN) {
            FakeCrashLibrary.logWarning(t)
        }
    }

    class FakeCrashLibrary private constructor() {
        companion object {
            fun log(priority: Int, tag: String?, message: String?) {}
            fun logWarning(t: Throwable?) {}
            fun logError(msg: String?, t: Throwable?) {
                //TODO:关键错误日志上报bugly
//            CrashReport.postCatchedException(new Exception(msg, t));
            }
        }

        init {
            throw AssertionError("No instances.")
        }
    }
}