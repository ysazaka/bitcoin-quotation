package br.com.ysazaka.bitcoinquotation.di

import android.content.Context
import br.com.ysazaka.bitcoinquotation.ui.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
@Singleton
@Component(modules = [DataModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory
}

@Module(subcomponents = [MainComponent::class])
object SubcomponentsModule