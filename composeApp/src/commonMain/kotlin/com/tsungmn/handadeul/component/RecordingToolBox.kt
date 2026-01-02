package com.tsungmn.handadeul.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RecordingToolBox(
    handlePlayback: () -> Unit,
    handleCancel: () -> Unit,
    handleComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isRecording by remember { mutableStateOf(true) }

    Row(
        modifier =
            modifier
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PlayBackStatus(
            isRecording = isRecording,
            handlePlayback = handlePlayback,
            modifier = Modifier.weight(1f)
        )
        PlayToolBox(handleCancel, handleComplete)
    }
}

@Composable
fun PlayBackStatus(
    isRecording: Boolean,
    handlePlayback: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val imageVector: ImageVector = when (isRecording) {
        true -> Icons.Rounded.Pause
        false -> Icons.Rounded.PlayArrow
    }
    val statusText = when (isRecording) {
        true -> "앱에서 녹음 중"
        false -> "일시 정지됨"
    }

    Row(
        modifier = modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(MaterialTheme.colorScheme.surface),
            onClick = handlePlayback,
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = imageVector,
                contentDescription = "Playback",
            )
        }
        Spacer(Modifier.width(10.dp))
        Text(
            statusText,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light)
        )
    }
}

@Composable
fun PlayToolBox(
    handleCancel: () -> Unit,
    handleComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .padding(3.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 10.dp),
    ) {
        TextButton(
            onClick = handleCancel,
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Cancel recording",
                    tint = Color(0xFFF76E6E),
                )
                Text(
                    "취소",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFFF76E6E),
                )
            }
        }
        Spacer(Modifier.width(5.dp))
        TextButton(
            onClick = handleComplete,
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Rounded.Stop,
                    contentDescription = "Stop recording",
                    tint = MaterialTheme.colorScheme.primary,
                )
                Text(
                    "완료",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

