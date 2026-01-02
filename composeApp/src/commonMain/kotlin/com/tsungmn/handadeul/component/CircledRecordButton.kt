package com.tsungmn.handadeul.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CircledRecordButton(
    buttonSize: Dp,
    iconSize: Dp,
    containerColor: Color = Color(0xFFF76E6E),
    onClick: () -> Unit,
) {
    IconButton(
        modifier = Modifier.size(buttonSize),
        colors = IconButtonDefaults.iconButtonColors().copy(containerColor),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = Icons.Rounded.Mic,
            contentDescription = "Recording"
        )
    }
}