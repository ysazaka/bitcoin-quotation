package br.com.ysazaka.bitcoinquotation.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import br.com.ysazaka.bitcoinquotation.data.model.Stat
import br.com.ysazaka.bitcoinquotation.data.network.MainApi
import retrofit2.Response


/**
 * Created by Glauco Sazaka on 23/09/2020
 */

class MainViewModel: ViewModel() {

    val chartLiveData: MutableLiveData<ChartData> = MutableLiveData()
    val statLiveData: MutableLiveData<Stat> = MutableLiveData()

    fun getChartData() {
        object : MainApi<ChartData>() {
            override fun onSuccess(response: Response<ChartData>) {
                val chartData = response.body()!!

                chartLiveData.value = chartData
            }
        }.getChartData()
    }

    fun getStats() {
        object : MainApi<Stat>() {
            override fun onSuccess(response: Response<Stat>) {
                val stat = response.body()!!

                statLiveData.value = stat
            }
        }.getStats()
    }

}
