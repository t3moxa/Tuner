package com.example.tuner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onNavigateToTuner: () -> Unit,
    onNavigateToMetronome: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonGradient = Brush.linearGradient(
        colors = listOf(Color.White, Color(0xFFDCDCDC))
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    )
    {
        Image(
            painter = painterResource(id = R.drawable.guitar_background),
            contentDescription = "Guitar background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.graphicsLayer { alpha = 0.2f }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .drawBehind {
                        drawLine(
                            color = Color(0xFF676767),
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 5f
                        )
                    }
            ) {
                IconButton(
                    onClick = { onNavigateToSettings() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp, 30.dp)
                    )
                }
                IconButton(
                    onClick = { onNavigateToTuner() },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(150.dp, 150.dp)
                        .shadow(6.dp, shape = CircleShape)
                        .border(BorderStroke(2.dp, Color.Black), shape = CircleShape)
                        .background(buttonGradient)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.guitar),
                        contentDescription = "Tuner",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .drawBehind {
                        drawLine(
                            color = Color(0xFF676767),
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 5f
                        )
                    }
            ) {
                IconButton(
                    onClick = { onNavigateToMetronome() },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(150.dp, 150.dp)
                        .shadow(6.dp, shape = CircleShape)
                        .border(BorderStroke(2.dp, Color.Black), shape = CircleShape)
                        .background(buttonGradient)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.metronome),
                        contentDescription = "Tuner",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }
}