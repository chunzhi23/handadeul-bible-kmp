package com.tsungmn.handadeul.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tsungmn.handadeul.component.CustomBottomAppBar
import com.tsungmn.handadeul.component.Header

@Composable
fun HomeScreen() {
    Surface(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .statusBarsPadding()
                .navigationBarsPadding(),
    ) {
        Column {
            Header(
                modifier = Modifier.padding(20.dp, 10.dp),
                leftSection = {
                    Text("한다들", style = MaterialTheme.typography.headlineLarge)
                },
                rightSection = {
                    IconButton({}) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            imageVector = Icons.Rounded.Tune,
                            contentDescription = "Settings",
                        )
                    }
                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                TextForToday(modifier = Modifier.padding(20.dp, 10.dp))
                Column(modifier = Modifier.padding(15.dp, 10.dp)) {
                    ReadingCard()
                    Spacer(Modifier.height(10.dp))
                    RecordingCard()
                    Spacer(Modifier.height(10.dp))
                    ShortcutCard()
                }
            }
            CustomBottomAppBar(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun TextForToday(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text("오늘의 말씀", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(10.dp))
        Text(
            "사람이 마음으로 자기의 길을 계획할지라도 그 걸음을 인도하는 자는 여호와시니라",
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "잠언 16장 9절",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "말씀 보러 가기",
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary,
                )
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = "Move to the bible",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Composable
private fun ReadingCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(20.dp, 15.dp)
    ) {
        Text(
            "설정한 통독 목표가 아직 없어요",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(Modifier.height(3.dp))
        Text("계획 세우고 함께 성경 통독해요!", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(5.dp))
        Button(
            colors = ButtonDefaults.buttonColors()
                .copy(containerColor = MaterialTheme.colorScheme.background),
            onClick = {/* TODO("Move to reading page") */ }) {
            Text(
                "통독 도전할께요",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}

@Composable
private fun RecordingCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(20.dp, 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                "설교 말씀을 쉽게 정리해드려요",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(Modifier.height(3.dp))
            Text("설교 말씀 녹음하기", style = MaterialTheme.typography.titleMedium)
        }
        IconButton(
            modifier = Modifier.size(54.dp),
            colors = IconButtonDefaults.iconButtonColors().copy(containerColor = Color(0xFFF76E6E)),
            onClick = {/* TODO("Record") */ },
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Rounded.Mic,
                contentDescription = "Recording"
            )
        }
    }
}

@Composable
private fun ShortcutCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(20.dp, 15.dp),
    ) {
        Text(
            "성경에 남긴 흔적을 빠르게 찾아드려요",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(Modifier.height(3.dp))
        Text("성경 바로가기", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Rounded.Bookmark,
                    contentDescription = "Bookmark",
                )
                Text(
                    "북마크",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Rounded.History,
                    contentDescription = "History",
                )
                Text(
                    "방문기록",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Rounded.EditNote,
                    contentDescription = "Notepad",
                )
                Text(
                    "메모",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                )
            }
        }
    }
}