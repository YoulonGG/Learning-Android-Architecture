package com.example.learningandroidarchitecture.crypto.domain

import com.example.learningandroidarchitecture.crypto.core.util.NetworkError
import com.example.learningandroidarchitecture.crypto.core.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}