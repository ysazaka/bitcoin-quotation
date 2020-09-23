package br.com.ysazaka.bitcoinquotation.data

import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
interface Repository {

    @GET("report")
    fun getChartData(
        @Query("timespan") timespan: String,
        @Query("rollingAverage") rollingAverage: String,
        @Query("start") start: String,
        @Query("format") format: String,
        @Query("sampled") sampled: String
    ): Call<ChartData>

}