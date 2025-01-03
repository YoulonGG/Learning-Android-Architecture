package com.example.learningandroidarchitecture.crypto.presentation

import com.example.learningandroidarchitecture.crypto.presentation.models.CoinUiModel

sealed interface CoinListAction {
    data class FetchCoinList(val coinUi: CoinUiModel): CoinListAction
    data object onRefresh: CoinListAction
}