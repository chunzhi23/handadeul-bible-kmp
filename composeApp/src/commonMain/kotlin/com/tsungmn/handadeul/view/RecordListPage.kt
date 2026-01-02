package com.tsungmn.handadeul.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tsungmn.handadeul.component.CircledRecordButton
import com.tsungmn.handadeul.component.Header
import com.tsungmn.handadeul.utils.formatLocalDate
import kotlinx.datetime.LocalDate

@Composable
fun RecordListPage() {
    Surface(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .statusBarsPadding()
                .navigationBarsPadding(),
    ) {
        Column {
            Header(modifier = Modifier.padding(20.dp, 10.dp))
            Spacer(Modifier.height(15.dp))
            HeadingBlock(Modifier.fillMaxWidth())
            Spacer(Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                HeadingToolBox(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 10.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(12.dp, 3.dp),
                )
                RecordListBox(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(MaterialTheme.colorScheme.surface)
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                // TODO("If recording")
//                RecordingToolBox(
//                    modifier = Modifier.padding(horizontal = 15.dp),
//                    handlePlayback = {},
//                    handleCancel = {},
//                    handleComplete = {}
//                )
                // TODO("If not recording")
                CircledRecordButton(buttonSize = 72.dp, iconSize = 36.dp) {}
            }
        }
    }
}

@Composable
private fun HeadingBlock(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("모든 녹음", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(5.dp))
        Text(
            "0개",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
            color = Color.LightGray,
        )
    }
}

@Composable
private fun HeadingToolBox(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconButton({/* TODO("Show menu") */ }) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu",
            )
        }
        Row {
            IconButton({/* TODO("Move to search page") */ }) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                )
            }
            Spacer(Modifier.width(5.dp))
            IconButton({/* TODO("Show dropdown") */ }) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "More",
                )
            }
        }
    }
}

@Composable
private fun RecordListBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        RecordListItem(
            modifier = Modifier.padding(5.dp, 8.dp, 15.dp, 8.dp),
            title = "Commodo amet facilisis donec turpis",
            speaker = "담임목사님",
            date = LocalDate(2026, 1, 2),
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp),
            thickness = 1.dp,
            color = Color.LightGray,
        )
        RecordListItem(
            modifier = Modifier.padding(5.dp, 8.dp, 15.dp, 8.dp),
            title = "Id euismod volutpat est aliquam",
            speaker = "담임목사님",
            date = LocalDate(2026, 1, 2),
            isFixed = true,
        )
    }
}

@Composable
private fun RecordListItem(
    title: String,
    speaker: String,
    date: LocalDate,
    isFixed: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val formattedDate = formatLocalDate(date)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton({/* Add favourite */ }) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Rounded.Star,
                contentDescription = "Favorite",
                tint = if (isFixed) Color(0xFFFFCE5C) else MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(Modifier.width(5.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(3.dp))
            Text(
                "$formattedDate · $speaker",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.LightGray,
            )
        }
    }
}
