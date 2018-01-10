package com.cryptoprices.manuninguno.cryptoprices

import com.cryptoprices.manuninguno.cryptoprices.commons.adapter.AdapterConstants
import com.cryptoprices.manuninguno.cryptoprices.commons.adapter.ViewType

class CryptoCoin(
        val id: String,
        val name: String,
        val symbol: String,
        val rank: Int,
        val priceUSD: Double,
        val priceBTC: Double,
        val volume24hUSD: Double,
        val marketCapUSD: Double,
        val availableSupply: Double,
        val totalSupply: Double,
        val maxSupply: Double,
        val percentChange1h: Double,
        val percentChange24h: Double,
        val percentChange7d: Double,
        val lastUpdated: Long
) : ViewType {
    override fun getViewType() = AdapterConstants.COINS
}