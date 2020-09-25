package br.com.ysazaka.bitcoinquotation.util

import java.text.NumberFormat
import java.util.*

/**
 * Created by Glauco Sazaka on 24/09/2020.
 */
object Utils {

    fun getMoneyText(value: Double, locale: Locale): String? {
        val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
        return currencyFormatter.format(value)
    }

}