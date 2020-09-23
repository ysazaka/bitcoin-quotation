package br.com.ysazaka.bitcoinquotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ysazaka.bitcoinquotation.ui.di.MainComponent
import br.com.ysazaka.bitcoinquotation.ui.main.MainFragment

/**
 * Created by Glauco Sazaka on 22/09/2020
 */
class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (applicationContext as BitcoinQuotationApp).appComponent.mainComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
