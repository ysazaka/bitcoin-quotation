package br.com.ysazaka.bitcoinquotation.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
class ChartValues(@SerializedName("x") var x: Double?, @SerializedName("y") var y: Double?)