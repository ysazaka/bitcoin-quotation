package br.com.ysazaka.bitcoinquotation

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Glauco Sazaka on 22/09/2020
 */
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
