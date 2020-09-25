package br.com.ysazaka.bitcoinquotation.data.network

import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import br.com.ysazaka.bitcoinquotation.data.model.Stat
import retrofit2.Callback

/**
 * Created by Glauco Sazaka on 24/09/2020.
 */

internal abstract class MainApi<T>: RESTCallback<T>() {

    fun getChartData() {
        rest.getChartData("market-price", "1week", "8hours", null, "json", null).enqueue(this as Callback<ChartData>)
    }

    fun getStats() {
        rest.getStats().enqueue(this as Callback<Stat>)
    }

}