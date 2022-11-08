package com.gzq.wanandroid.features.home.profile.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun LogoutDialogC(onDismiss: () -> Unit, confirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = "确定退出登录吗？",
                style = MaterialTheme.typography.titleMedium
            )
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "取消")
            }
        },
        confirmButton = {
            TextButton(onClick = confirm) {
                Text(text = "确定")
            }
        }
    )
}