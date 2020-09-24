package br.com.ysazaka.bitcoinquotation

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

import br.com.ysazaka.bitcoinquotation.di.DaggerAppComponent

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this)?.build()
//        return null
    }
}