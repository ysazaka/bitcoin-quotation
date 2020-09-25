package br.com.ysazaka.bitcoinquotation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.ysazaka.bitcoinquotation.R
import br.com.ysazaka.bitcoinquotation.ui.main.MainActivity
import com.orhanobut.hawk.Hawk

/**
 * Created by Glauco Sazaka on 23/09/2020
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (!Hawk.isBuilt()) Hawk.init(this).build()
        val handler = Handler()

        handler.postDelayed({
            val intent: Intent?
            intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }, 2500)
    }
}
