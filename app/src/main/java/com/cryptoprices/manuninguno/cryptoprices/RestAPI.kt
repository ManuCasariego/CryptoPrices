package com.cryptoprices.manuninguno.cryptoprices

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestAPI {
    private val cryptoAPI: CryptoAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        cryptoAPI = retrofit.create(CryptoAPI::class.java)

    }

    fun getCoins(start: Int, limit: Int, convert: String): Call<CryptoCoins> {
        return cryptoAPI.getCoins(start, limit, convert)
    }
}
