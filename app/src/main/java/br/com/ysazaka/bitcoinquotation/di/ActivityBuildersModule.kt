package br.com.ysazaka.bitcoinquotation.di

import br.com.ysazaka.bitcoinquotation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
@Module
abstract class ActivityBuildersModule {

//    @ContributesAndroidInjector(modules = [MainViewModelsModule::class, MainModule::class])
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity?

}