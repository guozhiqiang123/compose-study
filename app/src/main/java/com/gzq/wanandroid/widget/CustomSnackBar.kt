package com.gzq.wanandroid.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class SnackBarState {
    NorMal, Info, Done, Error
}

/**
 * 自定义全局通用snackbar
 */
@Composable
fun CustomSnackBar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
    state: SnackBarState = SnackBarState.NorMal
) {
    Snackbar(modifier.padding(12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (state != SnackBarState.NorMal) {
                Icon(
                    imageVector = when (state) {
                        SnackBarState.Info -> Icons.Outlined.Info
                        SnackBarState.Done -> Icons.Outlined.Done
                        SnackBarState.Error -> Icons.Outlined.Clear
                        else -> throw IllegalArgumentException("错误的参数")
                    },
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inverseOnSurface,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = data.visuals.message,
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
        }
    }
}