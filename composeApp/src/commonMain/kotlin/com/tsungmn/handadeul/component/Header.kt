package com.tsungmn.handadeul.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    leftSection: @Composable () -> Unit = { DefaultLeftSection() },
    rightSection: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        leftSection()
        rightSection()
    }
}

@Composable
fun DefaultLeftSection() {
    IconButton(onClick = {/* TODO("move to previous page") */ }) {
        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "previous page"
        )
    }
}