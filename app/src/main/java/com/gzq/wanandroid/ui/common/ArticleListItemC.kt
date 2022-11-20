package com.gzq.wanandroid.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.gzq.wanandroid.model.Article

@Composable
fun ArticleListItemC(article: Article, modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        val (title, attr, collectTag) = createRefs()
        Text(
            text = article.title,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, 6.dp)
                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    width = Dimension.fillToConstraints
                }
        )


        Row(modifier = Modifier
            .height(IntrinsicSize.Min)
            .constrainAs(attr) {
                start.linkTo(title.start)
                top.linkTo(title.bottom, 10.dp)
                bottom.linkTo(parent.bottom, 6.dp)
            }) {
            Text(
                text = article.superChapterName,
                style = TextStyle(
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.error.copy(alpha = 0.75f)
                ),
            )

            Divider(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .width(1.dp)
                    .fillMaxHeight(),
                color = MaterialTheme.colorScheme.outline
            )

            Text(
                text = article.shareUser.ifEmpty { article.author },
                style = TextStyle(fontSize = 10.sp, color = MaterialTheme.colorScheme.outline),
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
            )
            Text(
                text = article.niceDate,
                style = TextStyle(fontSize = 10.sp, color = MaterialTheme.colorScheme.outline)
            )
        }

        if (article.collect) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(20.dp)
                    .clip(RoundedCornerShape(topStart = 4.dp, bottomEnd = 4.dp))
                    .background(MaterialTheme.colorScheme.error)
                    .constrainAs(collectTag) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "已收藏",
                    style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.surface)
                )
            }
        }
    }
}