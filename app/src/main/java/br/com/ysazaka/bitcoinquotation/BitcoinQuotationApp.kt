package br.com.ysazaka.bitcoinquotation

import android.app.Application
import br.com.ysazaka.bitcoinquotation.di.ApplicationComponent
import br.com.ysazaka.bitcoinquotation.di.DaggerApplicationComponent

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
class BitcoinQuotationApp: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}