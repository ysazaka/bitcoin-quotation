package br.com.ysazaka.bitcoinquotation.di

import br.com.ysazaka.bitcoinquotation.data.Repository
import br.com.ysazaka.bitcoinquotation.data.MainRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(repository: MainRepository): Repository

}