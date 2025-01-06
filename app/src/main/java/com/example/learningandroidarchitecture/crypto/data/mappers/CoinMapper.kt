package com.example.learningandroidarchitecture.crypto.data.mappers

import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinDto
import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinPriceDto
import com.example.learningandroidarchitecture.crypto.domain.Coin
import com.example.learningandroidarchitecture.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24h = changePercent24h ?: 0.0
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}
