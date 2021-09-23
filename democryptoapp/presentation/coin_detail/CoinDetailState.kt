package com.legoratech.democryptoapp.presentation.coin_detail

import com.legoratech.democryptoapp.domain.model.Coin
import com.legoratech.democryptoapp.domain.model.CoinDetail
import com.legoratech.democryptoapp.utils.Resource

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
