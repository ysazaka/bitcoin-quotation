package br.com.ysazaka.bitcoinquotation.di

import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module


/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}