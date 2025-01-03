package com.example.learningandroidarchitecture.crypto.di

import com.example.learningandroidarchitecture.crypto.core.data.network.HttpClientFactory
import com.example.learningandroidarchitecture.crypto.data.networking.RemoteCoinDataSource
import com.example.learningandroidarchitecture.crypto.domain.CoinDataSource
import com.example.learningandroidarchitecture.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}