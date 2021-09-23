package com.legoratech.democryptoapp.domain.use_case.get_coins

import com.legoratech.democryptoapp.data.remote.dto.toCoin
import com.legoratech.democryptoapp.domain.model.Coin
import com.legoratech.democryptoapp.domain.model.CoinDetail
import com.legoratech.democryptoapp.domain.repository.CoinRepository
import com.legoratech.democryptoapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected Error"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't Reach Server. Please Check Your Internet"))
        }
    }
}