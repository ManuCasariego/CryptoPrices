package com.cryptoprices.manuninguno.cryptoprices.features.coins

import com.cryptoprices.manuninguno.cryptoprices.CryptoCoin
import rx.Observable


class CoinsManager() {
    fun getCoins(): Observable<List<CryptoCoin>> {
        return Observable.create { subscriber ->

            val coins = mutableListOf<CryptoCoin>()
            (1..10).mapTo(coins) {
                CryptoCoin(
                        id = "$it",
                        name = "name$it",
                        symbol = "XXX",
                        rank = it,
                        priceUSD = 2.2,
                        priceBTC = 3.4,
                        volume24hUSD = 1230.2,
                        marketCapUSD = 1111.11,
                        availableSupply = 345.2,
                        totalSupply = 1234215.235,
                        maxSupply = 0.2,
                        percentChange1h = 2.2,
                        percentChange7d = 4.4,
                        percentChange24h = 6.6,
                        lastUpdated = 120398991
                )
            }
            subscriber.onNext(coins)
        }
    }
}