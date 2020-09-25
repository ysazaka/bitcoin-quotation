package br.com.ysazaka.bitcoinquotation.data.network

import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import br.com.ysazaka.bitcoinquotation.data.model.Stat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
interface Services {

    @GET("charts/{chartName}")
    fun getChartData(
        @Path("chartName") chartName: String,
        @Query("timespan") timespan: String?,
        @Query("rollingAverage") rollingAverage: String?,
        @Query("start") start: String?,
        @Query("format") format: String?,
        @Query("sampled") sampled: Boolean?
    ): Call<ChartData>

    @GET("stats")
    fun getStats(): Call<Stat>

}