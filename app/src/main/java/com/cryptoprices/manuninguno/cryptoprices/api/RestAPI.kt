package com.cryptoprices.manuninguno.cryptoprices.api

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

    fun getCoins(start: String, limit: String, convert: String): Call<List<CryptoCoinResponse>> {
        return cryptoAPI.getCoins(start, limit, convert)
    }
}
