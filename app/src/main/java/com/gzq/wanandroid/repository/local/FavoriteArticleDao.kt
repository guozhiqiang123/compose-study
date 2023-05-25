package com.gzq.wanandroid.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gzq.wanandroid.model.FavoriteArticle

@Dao
interface FavoriteArticleDao {

    @Query("SELECT * FROM t_favorite_article")
    suspend fun queryAllFavoriteArticles(): List<FavoriteArticle>

    @Query("SELECT * FROM t_favorite_article WHERE id=:id AND userId==:userId")
    suspend fun queryById(id: Int, userId: Int): List<FavoriteArticle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articles: FavoriteArticle)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg articles: FavoriteArticle)
}