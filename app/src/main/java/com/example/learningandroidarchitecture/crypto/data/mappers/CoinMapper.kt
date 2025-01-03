package com.example.learningandroidarchitecture.crypto.data.mappers

import com.example.learningandroidarchitecture.crypto.data.networking.dto.CoinDto
import com.example.learningandroidarchitecture.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24h = changePercent24h
    )
}