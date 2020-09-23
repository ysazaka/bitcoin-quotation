package br.com.ysazaka.bitcoinquotation.data

import android.content.Context
import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import retrofit2.Call
import javax.inject.Inject

class MainRepository @Inject constructor(val context: Context) : Repository {

    override fun getChartData(
        timespan: String,
        rollingAverage: String,
        start: String,
        format: String,
        sampled: String
    ): Call<ChartData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}