package br.com.ysazaka.bitcoinquotation.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
class ChartData(
    @SerializedName("status") var status: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("unit") var unit: String?,
    @SerializedName("period") var period: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("values") var values: ChartValues?
)