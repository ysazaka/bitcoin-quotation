package br.com.ysazaka.bitcoinquotation.ui.di

import androidx.lifecycle.ViewModel
import br.com.ysazaka.bitcoinquotation.di.ViewModelKey
import br.com.ysazaka.bitcoinquotation.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}