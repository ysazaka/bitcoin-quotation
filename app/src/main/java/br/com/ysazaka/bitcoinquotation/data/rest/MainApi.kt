package br.com.ysazaka.bitcoinquotation.data.rest

import br.com.ysazaka.bitcoinquotation.data.model.ChartData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
interface MainApi {

    @GET("report")
    fun getChartData(
        @Query("timespan") timespan: String?,
        @Query("rollingAverage") rollingAverage: String?,
        @Query("start") start: String?,
        @Query("format") format: String?,
        @Query("sampled") sampled: Boolean?
    ): Call<ChartData>

}