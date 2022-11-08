package com.gzq.wanandroid.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    var id: Int?,
    var admin: Boolean?,
    var chapterTops: List<Int>?,
    var coinCount: Int?,
    var collectIds: List<Int>?,
    var email: String?,
    var icon: String?,
    var nickname: String?,
    var password: String?,
    var token: String?,
    var type: Int?,
    var username: String?,
) : Parcelable