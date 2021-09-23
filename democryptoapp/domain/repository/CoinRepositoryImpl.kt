package com.legoratech.democryptoapp.domain.repository

import com.legoratech.democryptoapp.data.remote.CoinPaprikaApi
import com.legoratech.democryptoapp.data.remote.dto.CoinDetailDto
import com.legoratech.democryptoapp.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}