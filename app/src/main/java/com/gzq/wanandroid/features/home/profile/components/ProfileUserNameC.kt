package com.gzq.wanandroid.features.home.profile.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.lerp
import com.gzq.wanandroid.features.home.profile.CollapsedOffsetY
import com.gzq.wanandroid.features.home.profile.CollapsedTextOffsetX
import com.gzq.wanandroid.features.home.profile.CollapsedTextOffsetY
import com.gzq.wanandroid.features.home.profile.CollapsedTextSize
import com.gzq.wanandroid.features.home.profile.CollapsedTextSizeLineHeight
import com.gzq.wanandroid.features.home.profile.ExpandedTextLineHeight
import com.gzq.wanandroid.features.home.profile.ExpandedTextOffsetX
import com.gzq.wanandroid.features.home.profile.ExpandedTextOffsetY
import com.gzq.wanandroid.features.home.profile.ExpandedTextSize

@Composable
fun ProfileUserNameC(name: String, scrollProvider: () -> Int) {
    val density = LocalDensity.current
    val collapseRange = with(density) { ExpandedTextOffsetY.toPx() }
    val offset = with(density) { CollapsedOffsetY.toPx() }
    val collapseFractionProvider: Float =
        ((scrollProvider() - offset) / collapseRange).coerceIn(0f, 1f)

    val textOffsetX = with(density) {
        lerp(ExpandedTextOffsetX, CollapsedTextOffsetX, collapseFractionProvider).roundToPx()
    }
    val textOffsetY = with(density) {
        lerp(ExpandedTextOffsetY, CollapsedTextOffsetY, collapseFractionProvider).roundToPx()
    }

    val textStyle = androidx.compose.ui.text.lerp(
        TextStyle(fontSize = ExpandedTextSize, lineHeight = ExpandedTextLineHeight),
        TextStyle(fontSize = CollapsedTextSize, lineHeight = CollapsedTextSizeLineHeight),
        collapseFractionProvider
    )
    Text(
        text = name,
        style = textStyle,
        modifier = Modifier.offset { IntOffset(x = textOffsetX, y = textOffsetY) }
    )
}