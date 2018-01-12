package com.cryptoprices.manuninguno.cryptoprices.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {
    @GET("/v1/ticker")
    fun getCoins(@Query("start") start:String,
                 @Query("limit") limit: String,
                 @Query("convert") convert: String)
            : Call<List<CryptoCoinResponse>>
}