package com.example.learningandroidarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningandroidarchitecture.crypto.presentation.CoinListState
import com.example.learningandroidarchitecture.crypto.presentation.coin_list.CoinListScreen
import com.example.learningandroidarchitecture.crypto.presentation.coin_list.components.CoinListItem
import com.example.learningandroidarchitecture.ui.theme.LearningAndroidArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningAndroidArchitectureTheme {
                CoinListScreen(uiState = CoinListState())
            }
        }
    }
}
