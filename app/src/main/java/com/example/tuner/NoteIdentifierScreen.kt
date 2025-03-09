package com.example.tuner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NoteIdentifierScreen(
    onNavigateToTuner : () -> Unit,
    onNavigateToMainScreen : () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier) {
    val buttonGradient = Brush.linearGradient(
        colors = listOf(Color.White, Color(0xFFE8E8E8))
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        IconButton(
            onClick = { onNavigateToMainScreen() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp, 30.dp)
            )
        }
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
        Column (
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(modifier = Modifier
                .weight(6f)){
                Box(
                    modifier = Modifier
                        .size(width = 375.dp, height = 275.dp)
                        .padding(16.dp)
                        .border(BorderStroke(4.dp, Color.Black), shape = RoundedCornerShape(8.dp))
                        .align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Up",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 5.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .offset(x = (-10).dp, y = (-50).dp)) {
                IconButton(
                    onClick = { onNavigateToTuner() },
                    modifier = Modifier
                        .size(56.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(10.dp))
                        .align(Alignment.TopEnd)
                        .background(buttonGradient, shape = RoundedCornerShape(10.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.guitar),
                        contentDescription = "Tuner",
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun drawIddentifiedNote(noteHZ: Int, modifier: Modifier = Modifier) {
    //todo
}