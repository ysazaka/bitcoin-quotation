package br.com.ysazaka.bitcoinquotation.ui.di

import br.com.ysazaka.bitcoinquotation.MainActivity
import br.com.ysazaka.bitcoinquotation.ui.main.MainFragment
import dagger.Subcomponent

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)

}