package com.gzq.wanandroid.features.home.profile.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun LoginWarningDialogC(onDismiss: () -> Unit, confirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = "需要登录才可以进行此操作哦！",
                style = MaterialTheme.typography.titleMedium
            )
        },
        confirmButton = {
            TextButton(onClick = confirm) {
                Text(text = "确定")
            }
        }
    )
}