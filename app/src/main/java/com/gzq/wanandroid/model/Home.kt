package com.gzq.wanandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gzq.wanandroid.core.gson.GsonUtils

data class HomeList(
    val curPage: Int,
    val datas: List<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

@Entity(tableName = "t_article")
data class Article(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "admin_add") val adminAdd: Boolean,
    @ColumnInfo(name = "apk_link") val apkLink: String,
    @ColumnInfo(name = "audit") val audit: Int,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "can_edit") val canEdit: Boolean,
    @ColumnInfo(name = "chapter_id") val chapterId: Int,
    @ColumnInfo(name = "chapter_name") val chapterName: String,
    @ColumnInfo(name = "collect") val collect: Boolean,
    @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "desc_md") val descMd: String,
    @ColumnInfo(name = "envelope_pic") val envelopePic: String,
    @ColumnInfo(name = "fresh") val fresh: Boolean,
    @ColumnInfo(name = "host") val host: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "nice_date") val niceDate: String,
    @ColumnInfo(name = "nice_share_date") val niceShareDate: String,
    @ColumnInfo(name = "origin") val origin: String,
    @ColumnInfo(name = "prefix") val prefix: String,
    @ColumnInfo(name = "project_link") val projectLink: String,
    @ColumnInfo(name = "publish_time") val publishTime: Long,
    @ColumnInfo(name = "real_super_chapter_id") val realSuperChapterId: Int,
    @ColumnInfo(name = "self_visible") val selfVisible: Int,
    @ColumnInfo(name = "share_date") val shareDate: Long,
    @ColumnInfo(name = "share_user") val shareUser: String,
    @ColumnInfo(name = "super_chapter_id") val superChapterId: Int,
    @ColumnInfo(name = "super_chapter_name") val superChapterName: String,
    @ColumnInfo(name = "tags") val tags: List<Tag>?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "visible") val visible: Int,
    @ColumnInfo(name = "zan") val zan: Int,
    @ColumnInfo(name = "update_time") val updateTime: Long
) {
    fun toJson(): String {
        return GsonUtils.gson.toJson(this)
    }
}

data class Tag(
    val name: String,
    val url: String
)