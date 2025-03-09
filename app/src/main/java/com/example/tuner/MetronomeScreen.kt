package com.example.tuner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MetronomeScreen(
    onNavigateToMainScreen : () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier) {
    val stress = remember { mutableStateOf("") }
    val BPM = remember { mutableStateOf("") }
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
                .weight(2f)
                .fillMaxSize()
            )
            {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(width = 150.dp, height = 130.dp)
                )
                {
                    Text(
                        text = "Stress every",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                    )
                    TextField(
                        value = stress.value,
                        onValueChange = { newText -> stress.value = newText },
                        label = { Text("5", fontSize = 40.sp) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White
                        ),
                        modifier = Modifier
                            .size(width = 60.dp, height = 50.dp)
                            .align(Alignment.Center)
                    )
                    Text(
                        text = "Beat",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }

            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(width = 210.dp, height = 110.dp)
                )
                {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .size(30.dp)
                            .shadow(3.dp, shape = CircleShape)
                            .background(Color.White)
                            .align(Alignment.TopStart),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "-",
                            color = Color.Black,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    TextField(
                        value = BPM.value,
                        onValueChange = { newText -> BPM.value = newText },
                        label = { Text("60", fontSize = 40.sp) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White
                        ),
                        modifier = Modifier
                            .size(width = 80.dp, height = 50.dp)
                            .align(Alignment.TopCenter)
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .size(30.dp)
                            .shadow(3.dp, shape = CircleShape)
                            .background(Color.White)
                            .align(Alignment.TopEnd),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "+",
                            color = Color.Black,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(
                        text = "BPM",
                        color = Color.Black,
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
            }
            Box(modifier = Modifier
                .weight(4f)
                .fillMaxSize()
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(120.dp)
                        .shadow(2.dp, shape = CircleShape)
                        .border(BorderStroke(1.dp, Color(0xFF000000).copy(alpha=0.5f)), shape = CircleShape)
                        .background(Color.White)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Tuner",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
        }
    }
}