package com.gzq.wanandroid.repository.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.model.FavoriteArticle

/**
 * exportSchema设置为true才支持自动升级
 */
@Database(
    entities = [Article::class, FavoriteArticle::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 2, to = 3)]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    abstract fun favoriteArticleDao(): FavoriteArticleDao
}