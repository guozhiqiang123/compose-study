package com.gzq.wanandroid.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 用户基本信息
 */
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


data class UserShareList(
    val coinInfo: CoinInfo?,
    val shareArticles: ShareArticles?
)

/**
 * 积分、排名等信息
 */
data class CoinInfo(
    val coinCount: Int,
    val level: Int,
    val nickname: String,
    val rank: String,
    val userId: Int,
    val username: String
)

data class ShareArticles(
    val curPage: Int,
    val datas: List<Article>?,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class CollectionArticles(
    val curPage: Int,
    val datas: List<Article>?,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)