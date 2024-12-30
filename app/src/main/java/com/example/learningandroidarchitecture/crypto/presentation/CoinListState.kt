package com.example.learningandroidarchitecture.crypto.presentation

import androidx.compose.runtime.Immutable
import com.example.learningandroidarchitecture.crypto.presentation.models.CoinUiModel

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUiModel> = emptyList(),
    val selectedCoin: CoinUiModel? = null
)
