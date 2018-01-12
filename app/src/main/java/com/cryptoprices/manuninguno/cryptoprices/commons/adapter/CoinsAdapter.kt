package com.cryptoprices.manuninguno.cryptoprices.commons.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cryptoprices.manuninguno.cryptoprices.CryptoCoin


class CoinsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.COINS, CoinsDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    fun addCoins(coins: List<CryptoCoin>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert coins and the loading at the end of the list
        items.addAll(coins)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1) // plus the loading item
    }

    fun clearAndAddCoins(coins: List<CryptoCoin>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())
        items.addAll(coins)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getCoins(): List<CryptoCoin> {
        return items
                .filter { it.getViewType() == AdapterConstants.COINS }
                .map { it as CryptoCoin }
    }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex


}