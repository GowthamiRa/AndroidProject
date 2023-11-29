package com.homedecors.main.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.homedecors.R
import com.homedecors.main.utils.SharedPreferenceManager

class SplashActivity : AppCompatActivity() {

    var isLogin = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        SharedPreferenceManager.instance.init(applicationContext)
        isLogin = SharedPreferenceManager.instance.getBooleanFromPreference(SharedPreferenceManager.IS_LOGGED_IN)

            val handler = Handler()
            handler.postDelayed({
                if(isLogin){
                    val intent = Intent(applicationContext, ProductActivity::class.java)
                    startActivity(intent)
                    finish()
                }else {
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }, 1500)

    }
}