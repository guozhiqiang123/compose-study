package com.gzq.wanandroid.repository.local

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.gzq.wanandroid.core.gson.GsonUtils
import com.gzq.wanandroid.model.Tag

class Converters {
    @TypeConverter
    fun listTags2String(tags: List<Tag>): String {
        return GsonUtils.gson.toJson(tags)
    }

    @TypeConverter
    fun string2ListTags(result: String): List<Tag> {
        return GsonUtils.gson.fromJson(result, object : TypeToken<List<Tag>>() {}.type)
    }
}