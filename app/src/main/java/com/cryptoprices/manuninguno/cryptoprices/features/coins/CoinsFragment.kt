package com.cryptoprices.manuninguno.cryptoprices.features.coins

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cryptoprices.manuninguno.cryptoprices.R
import com.cryptoprices.manuninguno.cryptoprices.commons.RxBaseFragment
import com.cryptoprices.manuninguno.cryptoprices.commons.adapter.CoinsAdapter
import com.cryptoprices.manuninguno.cryptoprices.commons.extensions.inflate
import kotlinx.android.synthetic.main.coins_list_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class CoinsFragment : RxBaseFragment() {

    private val coinsManager by lazy { CoinsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.coins_list_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        coins_list.setHasFixedSize(true)
        coins_list.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            requestCoins()
        }
    }

    private fun requestCoins() {
        val subscription = coinsManager.getCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievedCoins ->
                            (coins_list.adapter as CoinsAdapter).addCoins(retrievedCoins)
                        },
                        { e ->
                            Snackbar.make(coins_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (coins_list.adapter == null) {
            coins_list.adapter = CoinsAdapter()
        }
    }
}
