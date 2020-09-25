package br.com.ysazaka.bitcoinquotation.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Glauco Sazaka on 24/09/2020.
 */
data class Stat (
    @SerializedName("market_price_usd") var marketPriceUsd: Double?
)