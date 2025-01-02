package com.example.learningandroidarchitecture.crypto.data.networking

import com.example.learningandroidarchitecture.crypto.core.util.NetworkError
import com.example.learningandroidarchitecture.crypto.core.util.Result
import com.example.learningandroidarchitecture.crypto.domain.Coin
import com.example.learningandroidarchitecture.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient


class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun get(): Result<List<Coin>, NetworkError> {

    }

}