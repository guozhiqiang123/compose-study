package com.gzq.wanandroid.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun OnDevelopingDialogC(onDismiss: () -> Unit) {

    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = "该功能正在开发中哦",
                style = MaterialTheme.typography.titleMedium
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "确定")
            }
        }
    )
}