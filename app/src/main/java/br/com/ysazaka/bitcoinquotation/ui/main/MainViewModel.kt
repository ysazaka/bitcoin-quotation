package br.com.ysazaka.bitcoinquotation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ysazaka.bitcoinquotation.data.rest.MainApi
import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import javax.inject.Inject

/**
 * Created by Glauco Sazaka on 23/09/2020
 */

class MainViewModel @Inject constructor(val mainApi: MainApi) : ViewModel() {

    private val _chartData = MutableLiveData<ChartData>()
    val chartData: LiveData<ChartData>
        get() = _chartData


}
