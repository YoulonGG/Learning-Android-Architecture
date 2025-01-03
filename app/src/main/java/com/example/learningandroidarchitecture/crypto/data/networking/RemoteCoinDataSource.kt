package com.example.learningandroidarchitecture.crypto.data.networking

import com.example.learningandroidarchitecture.crypto.core.data.network.constructUrl
import com.example.learningandroidarchitecture.crypto.core.data.network.safeCall
import com.example.learningandroidarchitecture.crypto.core.util.NetworkError
import com.example.learningandroidarchitecture.crypto.core.util.Result
import com.example.learningandroidarchitecture.crypto.core.util.map
import com.example.learningandroidarchitecture.crypto.data.mappers.toCoin
import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinResponseDto
import com.example.learningandroidarchitecture.crypto.domain.Coin
import com.example.learningandroidarchitecture.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get


class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoin(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}