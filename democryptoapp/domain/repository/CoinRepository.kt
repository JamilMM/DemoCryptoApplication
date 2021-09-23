package com.legoratech.democryptoapp.domain.repository

import com.legoratech.democryptoapp.data.remote.dto.CoinDetailDto
import com.legoratech.democryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto

}