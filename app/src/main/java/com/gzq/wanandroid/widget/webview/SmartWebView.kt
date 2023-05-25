package com.gzq.wanandroid.widget.webview

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.webkit.WebView
import kotlin.math.abs


/**
 * 可以监听滚动到顶部或者底部的WebView
 */
interface OnWebViewScrollChangeListener {
    fun onPageEnd()
    fun onPageTop()
    fun onScrollUp()
    fun onScrollDown()
}

class SmartWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

    private var lastScrollY: Int = 0

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastScrollY = scrollY
            }

            MotionEvent.ACTION_MOVE -> {
                if (mScrollListener != null && abs(lastScrollY - scrollY) > 100) {
                    if (lastScrollY > scrollY) {
                        mScrollListener!!.onScrollDown()
                        if (height + scrollY >= contentHeight * scale) {
                            mScrollListener!!.onPageEnd()
                        }
                    } else {
                        mScrollListener!!.onScrollUp()
                        if (scrollY == 0) {
                            mScrollListener!!.onPageTop()
                        }
                    }
                    lastScrollY = scrollY
                }
            }

            MotionEvent.ACTION_UP -> {
                if (mScrollListener != null) {
                    if (scrollY == 0) {
                        mScrollListener!!.onPageTop()
                    } else if (height + scrollY >= contentHeight * scale) {
                        mScrollListener!!.onPageEnd()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    private var mScrollListener: OnWebViewScrollChangeListener? = null

    fun setOnWebViewScrollListener(listener: OnWebViewScrollChangeListener) {
        this.mScrollListener = listener
    }
}