package com.example.learningandroidarchitecture.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningandroidarchitecture.crypto.presentation.CoinListAction
import com.example.learningandroidarchitecture.crypto.presentation.CoinListState
import com.example.learningandroidarchitecture.crypto.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    if(state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {
                        onAction(CoinListAction.FetchCoinList(coinUi))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}

//@PreviewLightDark
//@Composable
//private fun CoinListScreenPreview() {
//    CryptoTrackerTheme {
//        CoinListScreen(
//            state = CoinListState(
//                coins = (1..100).map {
//                    previewCoin.copy(id = it.toString())
//                }
//            ),
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.background),
//            onAction = {}
//        )
//    }
//}



