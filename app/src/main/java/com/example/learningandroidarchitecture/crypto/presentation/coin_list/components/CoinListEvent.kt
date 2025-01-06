package com.example.learningandroidarchitecture.crypto.presentation.coin_list.components

import com.example.learningandroidarchitecture.crypto.core.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}