package com.example.learningandroidarchitecture.crypto.data.networking

import com.example.learningandroidarchitecture.crypto.core.data.network.constructUrl
import com.example.learningandroidarchitecture.crypto.core.data.network.safeCall
import com.example.learningandroidarchitecture.crypto.core.util.NetworkError
import com.example.learningandroidarchitecture.crypto.core.util.Result
import com.example.learningandroidarchitecture.crypto.core.util.map
import com.example.learningandroidarchitecture.crypto.data.mappers.toCoin
import com.example.learningandroidarchitecture.crypto.data.mappers.toCoinPrice
import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinHistoryDto
import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinResponseDto
import com.example.learningandroidarchitecture.crypto.domain.Coin
import com.example.learningandroidarchitecture.crypto.domain.CoinDataSource
import com.example.learningandroidarchitecture.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime


class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}