package com.legoratech.democryptoapp.presentation.coin_list

import com.legoratech.democryptoapp.domain.model.Coin
import com.legoratech.democryptoapp.utils.Resource

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
