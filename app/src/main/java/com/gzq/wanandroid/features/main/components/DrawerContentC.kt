package com.gzq.wanandroid.features.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gzq.wanandroid.features.main.BottomNavigationModel

@Composable
fun ColumnScope.DrawableContentC(
    bottomModels: List<BottomNavigationModel>,
    isSelect: (BottomNavigationModel) -> Boolean,
    onClick: (BottomNavigationModel) -> Unit
) {
    bottomModels.forEach { model ->
        DrawerTab(
            isSelect = isSelect(model),
            label = model.label,
            selectIcon = model.selectIcon,
            unSelectIcon = model.unSelectIcon,
            onClick = { onClick(model) }
        )
    }
}

@Composable
fun DrawerTab(
    modifier: Modifier = Modifier, isSelect: Boolean,
    label: String,
    selectIcon: ImageVector,
    unSelectIcon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.padding(start = 20.dp),
            imageVector = if (isSelect) selectIcon else unSelectIcon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = label,
            color = if (isSelect) MaterialTheme.colorScheme.primary else Color.Unspecified,
            fontWeight = if (isSelect) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}