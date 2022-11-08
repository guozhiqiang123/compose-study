package com.gzq.wanandroid.features.home.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.gzq.wanandroid.core.preview.ThemePreviews
import com.gzq.wanandroid.model.HomeListItem
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeListItemC(modifier: Modifier = Modifier, data: HomeListItem, click: () -> Unit) {
    OutlinedCard(
        onClick = click,
        modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
        colors = CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = data.title,
            Modifier.padding(8.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        )

    }

}


@ThemePreviews
@Composable
fun PreviewHomeListItemC() {
    val json = "{\n" +
            "        \"adminAdd\": false,\n" +
            "        \"apkLink\": \"\",\n" +
            "        \"audit\": 1,\n" +
            "        \"author\": \"郭霖\",\n" +
            "        \"canEdit\": false,\n" +
            "        \"chapterId\": 409,\n" +
            "        \"chapterName\": \"郭霖\",\n" +
            "        \"collect\": false,\n" +
            "        \"courseId\": 13,\n" +
            "        \"desc\": \"\",\n" +
            "        \"descMd\": \"\",\n" +
            "        \"envelopePic\": \"\",\n" +
            "        \"fresh\": false,\n" +
            "        \"host\": \"\",\n" +
            "        \"id\": 24781,\n" +
            "        \"isAdminAdd\": false,\n" +
            "        \"link\": \"https://mp.weixin.qq.com/s/-28hoaXeWj7bQfAwHKYsjw\",\n" +
            "        \"niceDate\": \"2022-10-26 00:00\",\n" +
            "        \"niceShareDate\": \"2022-10-26 23:04\",\n" +
            "        \"origin\": \"\",\n" +
            "        \"prefix\": \"\",\n" +
            "        \"projectLink\": \"\",\n" +
            "        \"publishTime\": 1666713600000,\n" +
            "        \"realSuperChapterId\": 407,\n" +
            "        \"selfVisible\": 0,\n" +
            "        \"shareDate\": 1666796684000,\n" +
            "        \"shareUser\": \"\",\n" +
            "        \"superChapterId\": 408,\n" +
            "        \"superChapterName\": \"公众号\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"name\": \"公众号\",\n" +
            "            \"url\": \"/wxarticle/list/409/1\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"title\": \"用Kotlin进行跨平台开发，看这一篇就够了\",\n" +
            "        \"type\": 0,\n" +
            "        \"userId\": -1,\n" +
            "        \"visible\": 1,\n" +
            "        \"zan\": 0\n" +
            "      }"
    AndroidTemplateTheme {
        HomeListItemC(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(
                    top = 12.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .clickable {

                }, data = Gson().fromJson(json, HomeListItem::class.java)
        ) {

        }
    }
}