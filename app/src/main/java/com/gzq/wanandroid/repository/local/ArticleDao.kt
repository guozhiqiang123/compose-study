package com.gzq.wanandroid.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gzq.wanandroid.model.Article

@Dao
interface ArticleDao {
    /**
     * 查询所有阅读过的文章
     */
    @Query("SELECT * FROM t_article")
    suspend fun fetchAll(): List<Article>

    /**
     * 插入阅读过的文章
     */
    @Insert
    suspend fun insert(articles: Article)

    /**
     * 根据id查询
     */
    @Query("SELECT * FROM t_article WHERE id==:id AND userId==:userId")
    suspend fun queryById(id: Int, userId: Int): List<Article>

    /**
     * 删除某篇阅读记录
     */
    @Delete
    suspend fun delete(article: Article)

    /**
     * 更新数据
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(article: Article)
}