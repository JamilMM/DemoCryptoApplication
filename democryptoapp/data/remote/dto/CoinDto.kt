package com.legoratech.democryptoapp.data.remote.dto

import com.legoratech.democryptoapp.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun CoinDto.toCoin(): Coin {
   return Coin(
       id = id,
       is_active = is_active,
       name = name,
       symbol = symbol,
       rank = rank

   )
}