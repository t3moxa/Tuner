package com.example.tuner

import android.app.Application
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Composable
fun MetronomeScreen(
    onNavigateToMainScreen : () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MetronomeViewModel = viewModel()) {
    val metronomeUiState by viewModel.uiState.collectAsState()
    val playButtonIcon = if (!metronomeUiState.isPlaying) {
        Icons.Filled.PlayArrow
    } else {
        ImageVector.vectorResource(id = R.drawable.pause)
    }
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
                        fontSize = 25.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                    )
                    TextField(
                        value = metronomeUiState.stress.toString(),
                        onValueChange = {
                            newValue ->
                            if (newValue.isNotEmpty()) {
                                viewModel.onStressChanged(newValue.toInt())
                            } else {
                                viewModel.onStressChanged(0)
                            }
                                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        placeholder = { Text("5") },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White
                        ),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        ),
                        modifier = Modifier
                            .size(width = 100.dp, height = 65.dp)
                            .align(Alignment.Center)
                    )
                    Text(
                        text = "Beat",
                        fontSize = 25.sp,
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
                        onClick = {
                            viewModel.onBPMChanged(metronomeUiState.BPM.minus(1))
                        },
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
                        value = metronomeUiState.BPM.toString(),
                        onValueChange = {
                                newValue ->
                            if (newValue.isNotEmpty()) {
                                viewModel.onBPMChanged(newValue.toInt())
                            } else {
                                viewModel.onBPMChanged(0)
                            }
                                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White
                        ),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        ),
                        modifier = Modifier
                            .size(width = 100.dp, height = 65.dp)
                            .align(Alignment.TopCenter)
                            .offset(y = (-10).dp)
                    )
                    Button(
                        onClick = {
                            viewModel.onBPMChanged(metronomeUiState.BPM.plus(1))
                        },
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
                    onClick = {
                        viewModel.toggleMetronome()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(120.dp)
                        .shadow(2.dp, shape = CircleShape)
                        .border(BorderStroke(1.dp, Color(0xFF000000).copy(alpha=0.5f)), shape = CircleShape)
                        .background(Color.White)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = playButtonIcon,
                        contentDescription = "Tuner",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
        }
    }
}

data class MetronomeUiState(
    val stress: Int = 0,
    val BPM: Int = 0,
    val isPlaying: Boolean = false
)

class MetronomeViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(MetronomeUiState())
    val uiState: StateFlow<MetronomeUiState> = _uiState.asStateFlow()

    private val soundPool: SoundPool
    private val soundMap: MutableMap<Int, Int> = mutableMapOf()

    fun onStressChanged(newStress: Int) {
        _uiState.value = _uiState.value.copy(stress = newStress)
    }

    fun onBPMChanged(newBPM: Int) {
        _uiState.value = _uiState.value.copy(BPM = newBPM)
    }

    fun resetApp() {
        _uiState.value = MetronomeUiState(stress = 5, BPM = 60, isPlaying = false)
    }

    fun toggleMetronome() {
        if (!_uiState.value.isPlaying) {
            _uiState.value = _uiState.value.copy(isPlaying = true)

            val period = (60.0 / _uiState.value.BPM)
            var stressCount = 0

            viewModelScope.launch {
                while (_uiState.value.isPlaying) {
                    stressCount += 1
                    if (stressCount == _uiState.value.stress) {
                        soundPool.play(2, 1f, 1f, 0, 0, 1f)
                        stressCount = 0
                    }
                    else {
                        soundPool.play(1, 1f, 1f, 0, 0, 1f)
                    }
                    delay((period*1000).toLong())
                }
            }
        }
        else {
            _uiState.value = _uiState.value.copy(isPlaying = false)
        }
    }

    init {
        resetApp()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()

        soundMap[1] = soundPool.load(application, R.raw.beat, 1)
        soundMap[2] = soundPool.load(application, R.raw.beat_stressed, 2)
    }

    fun playSound(soundId: Int) {
        soundMap[soundId]?.let {
            soundPool.play(it, 1f, 1f, 1, 0, 1f)
        }
    }

    override fun onCleared() {
        super.onCleared()
        soundPool.release()
    }
}