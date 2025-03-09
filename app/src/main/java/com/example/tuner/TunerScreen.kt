package com.example.tuner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TunerScreen(
    onNavigateToNoteIdentifier : () -> Unit,
    onNavigateToMainScreen : () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier) {
    val buttonGradient = Brush.linearGradient(
        colors = listOf(Color.White, Color(0xFFE8E8E8))
    )
    val buttonSize = 20.dp
    val fontSize = 20.sp
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
            Box(
                modifier = Modifier
                    .weight(5f)
            ) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(16.dp)
                        .border(BorderStroke(4.dp, Color.Black), shape = RoundedCornerShape(8.dp))
                        .align(Alignment.Center)
                ) {
                }

            }
            Row (
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "E",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "A",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "D",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "G",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "B",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(buttonSize)
                        .shadow(3.dp, shape = CircleShape)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "E",
                        color = Color.Black,
                        fontSize = fontSize,
                        textAlign = TextAlign.Center)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .offset(x = (-10).dp, y = (-50).dp)
            ) {
                IconButton(
                    onClick = { onNavigateToNoteIdentifier() },
                    modifier = Modifier
                        .size(56.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(10.dp))
                        .background(buttonGradient, shape = RoundedCornerShape(16.dp))
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.note),
                        contentDescription = "Tuner",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}