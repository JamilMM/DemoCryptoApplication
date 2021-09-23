package com.legoratech.democryptoapp.domain.use_case.get_coin

import com.legoratech.democryptoapp.data.remote.dto.toCoin
import com.legoratech.democryptoapp.data.remote.dto.toCoinDetail
import com.legoratech.democryptoapp.domain.model.Coin
import com.legoratech.democryptoapp.domain.model.CoinDetail
import com.legoratech.democryptoapp.domain.repository.CoinRepository
import com.legoratech.democryptoapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected Error"))
        } catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't Reach Server. Please Check Your Internet"))
        }
    }
}