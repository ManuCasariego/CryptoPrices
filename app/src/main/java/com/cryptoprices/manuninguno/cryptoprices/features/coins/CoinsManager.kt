package com.cryptoprices.manuninguno.cryptoprices.features.coins

import com.cryptoprices.manuninguno.cryptoprices.CryptoCoin
import com.cryptoprices.manuninguno.cryptoprices.api.RestAPI
import rx.Observable


class CoinsManager(private val api: RestAPI = RestAPI()) {
    fun getCoins(start: String = "0", limit: String = "100", convert: String = "USD"): Observable<List<CryptoCoin>> {
        return Observable.create { subscriber ->

            val callResponse = api.getCoins(start, limit, convert)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val coins = response.body()!!.map {
                    CryptoCoin(
                            id = it.id,
                            name = it.name,
                            symbol = it.symbol,
                            rank = 2,
                            priceUSD = it.price_usd,
                            priceBTC = 3.4,
                            volume24hUSD = 1230.2,
                            marketCapUSD = 1111.11,
                            availableSupply = 345.2,
                            totalSupply = 1234215.235,
                            maxSupply = 0.2,
                            percentChange1h = 2.2,
                            percentChange7d = 4.4,
                            percentChange24h = 6.6,
                            lastUpdated = 120398991)
                }
                subscriber.onNext(coins)
                subscriber.onCompleted()

            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}