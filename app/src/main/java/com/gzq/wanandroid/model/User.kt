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
    val datas: List<ShareData>?,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class ShareData(
    val adminAdd: Boolean,
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val host: String,
    val id: Int,
    val isAdminAdd: Boolean,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Any>?,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)