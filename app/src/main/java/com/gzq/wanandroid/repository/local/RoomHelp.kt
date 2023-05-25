package com.gzq.wanandroid.repository.local

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration

object RoomHelp {
    lateinit var db: AppDatabase

    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "compose-study"
        ).addMigrations(roomUpdate1To2()).build()
    }

    /**
     * 第1个版本因为没有开启room数据库自动升级，所以这里手动升级
     */
    private fun roomUpdate1To2(): Migration = Migration(1, 2) { database ->
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS t_favorite_article (" +
                    "`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`id` INTEGER NOT NULL, " +
                    "`admin_add` INTEGER NOT NULL, " +
                    "`apk_link` TEXT NOT NULL, " +
                    "`audit` INTEGER NOT NULL, " +
                    "`author` TEXT NOT NULL, " +
                    "`can_edit` INTEGER NOT NULL, " +
                    "`chapter_id` INTEGER NOT NULL, " +
                    "`chapter_name` TEXT NOT NULL, " +
                    "`collect` INTEGER NOT NULL, " +
                    "`course_id` INTEGER NOT NULL, " +
                    "`desc` TEXT NOT NULL, " +
                    "`desc_md` TEXT NOT NULL, " +
                    "`envelope_pic` TEXT NOT NULL, " +
                    "`fresh` INTEGER NOT NULL, " +
                    "`host` TEXT NOT NULL, " +
                    "`link` TEXT NOT NULL, " +
                    "`nice_date` TEXT NOT NULL, " +
                    "`nice_share_date` TEXT NOT NULL, " +
                    "`origin` TEXT NOT NULL, " +
                    "`prefix` TEXT NOT NULL, " +
                    "`project_link` TEXT NOT NULL, " +
                    "`publish_time` INTEGER NOT NULL, " +
                    "`real_super_chapter_id` INTEGER NOT NULL, " +
                    "`self_visible` INTEGER NOT NULL, " +
                    "`share_date` INTEGER NOT NULL, " +
                    "`share_user` TEXT NOT NULL, " +
                    "`super_chapter_id` INTEGER NOT NULL, " +
                    "`super_chapter_name` TEXT NOT NULL, " +
                    "`tags` TEXT, `title` TEXT NOT NULL, " +
                    "`type` INTEGER NOT NULL, " +
                    "`userId` INTEGER NOT NULL, " +
                    "`visible` INTEGER NOT NULL, " +
                    "`zan` INTEGER NOT NULL, " +
                    "`update_time` INTEGER NOT NULL)"
        )

    }
}