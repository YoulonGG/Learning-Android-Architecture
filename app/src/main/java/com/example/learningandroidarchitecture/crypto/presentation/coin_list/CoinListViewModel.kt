package com.example.learningandroidarchitecture.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningandroidarchitecture.crypto.core.util.onError
import com.example.learningandroidarchitecture.crypto.core.util.onSuccess
import com.example.learningandroidarchitecture.crypto.domain.CoinDataSource
import com.example.learningandroidarchitecture.crypto.presentation.CoinListAction
import com.example.learningandroidarchitecture.crypto.presentation.CoinListState
import com.example.learningandroidarchitecture.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {


    fun onAction(event: CoinListAction) {
        when(event) {
            is CoinListAction.FetchCoinList -> TODO()
            CoinListAction.onRefresh -> TODO()
        }
    }


    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadingCoin() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            CoinListState()
        )

    private fun loadingCoin() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            coinDataSource
                .getCoin()
                .onError { error ->
                    _state.update { it.copy(isLoading = false) }
                }
                .onSuccess { coins ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            coins = coins.map { it.toCoinUi() }
                        )
                    }
                }
        }
    }
}