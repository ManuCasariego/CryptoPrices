package com.cryptoprices.manuninguno.cryptoprices.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cryptoprices.manuninguno.cryptoprices.CryptoCoin
import com.cryptoprices.manuninguno.cryptoprices.R
import com.cryptoprices.manuninguno.cryptoprices.commons.extensions.inflate
import kotlinx.android.synthetic.main.coin_item.view.*


class CoinsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as CryptoCoin)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.coin_item)){
        fun bind(item:CryptoCoin) = with(itemView){
            coin_name_textView.text = item.name
            coin_1h_variation.text = item.percentChange1h.toString()
            coin_24h_variation.text = item.percentChange24h.toString()
            coin_7d_variation.text = item.percentChange7d.toString()
            coin_price_textView.text = item.priceUSD.toString()
        }
    }

}