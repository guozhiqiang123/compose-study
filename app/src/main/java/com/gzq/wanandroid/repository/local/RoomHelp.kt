package com.gzq.wanandroid.repository.local

import android.content.Context
import androidx.room.Room

object RoomHelp {
    lateinit var db: AppDatabase

    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "compose-study"
        ).build()
    }
}