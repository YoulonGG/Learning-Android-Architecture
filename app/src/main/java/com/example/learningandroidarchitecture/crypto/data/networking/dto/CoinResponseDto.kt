package com.example.learningandroidarchitecture.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDto(
    val data: List<CoinDto>
)