package br.com.ysazaka.bitcoinquotation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.ysazaka.bitcoinquotation.MainActivity
import br.com.ysazaka.bitcoinquotation.R

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()

        handler.postDelayed({
            val intent: Intent?
            intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }, 2500)
    }
}
