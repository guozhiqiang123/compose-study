package com.gzq.wanandroid.features.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gzq.wanandroid.core.quality.LogCompositions
import com.gzq.wanandroid.features.main.BottomNavigationModel
import com.gzq.wanandroid.features.main.bottomModels

@Composable
fun BottomNavigationC(
    isSelect: (BottomNavigationModel) -> Boolean,
    onClick: (BottomNavigationModel) -> Unit
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface,
    ) {
        bottomModels.forEach { model ->
            BottomTab(
                isSelect = isSelect(model),
                label = model.label,
                selectIcon = model.selectIcon,
                unSelectIcon = model.unSelectIcon,
                onClick = { onClick(model) }
            )
        }
    }
}

@Composable
fun RowScope.BottomTab(
    modifier: Modifier = Modifier,
    isSelect: Boolean,
    label: String,
    selectIcon: ImageVector,
    unSelectIcon: ImageVector,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        selected = isSelect,
        label = {
            Text(
                text = label,
                fontWeight = if (isSelect) FontWeight.Bold else FontWeight.Normal,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }, icon = {
            Box(Modifier.padding(top = 6.dp), contentAlignment = Alignment.Center) {
                if (isSelect) {
                    Box(
                        Modifier
                            .size(width = 44.dp, height = 22.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.medium))
                    )
                }
                Icon(
                    imageVector = if (isSelect) selectIcon else unSelectIcon,
                    contentDescription = null,
                    Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        onClick = onClick,
        modifier = modifier
    )
}