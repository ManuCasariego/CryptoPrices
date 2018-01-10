package com.cryptoprices.manuninguno.cryptoprices

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {
    @GET("/v1/ticker/")
    fun getCoins(@Query("start") start:Int,
                 @Query("limit") limit: Int,
                 @Query("convert") convert: String)
            : Call<CryptoCoins>
}