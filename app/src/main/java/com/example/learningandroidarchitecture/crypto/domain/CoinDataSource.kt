package com.example.learningandroidarchitecture.crypto.domain

import com.example.learningandroidarchitecture.crypto.core.util.NetworkError
import com.example.learningandroidarchitecture.crypto.core.util.Result

interface CoinDataSource {
    suspend fun get(): Result<List<Coin>, NetworkError>
}