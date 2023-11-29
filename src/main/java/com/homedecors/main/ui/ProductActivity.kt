package com.homedecors.main.ui

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.homedecors.R
import com.homedecors.main.utils.SharedPreferenceManager

class ProductActivity : AppCompatActivity() {

    lateinit var logout : TextView
    lateinit var kingsize_bed_lay : LinearLayout
    lateinit var garden_table_lay : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_layout)

        logout = findViewById(R.id.logout)
        kingsize_bed_lay = findViewById(R.id.kingsize_bed_lay)
        garden_table_lay = findViewById(R.id.garden_table_lay)

        logout.setOnClickListener {
            SharedPreferenceManager.instance.storeBooleanInPreference(SharedPreferenceManager.IS_LOGGED_IN, false);
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        kingsize_bed_lay.setOnClickListener {

            val intent = Intent(applicationContext, DashboardActivity::class.java)
            intent.putExtra("productID", "1")
            startActivity(intent)
        }

        garden_table_lay.setOnClickListener {

            val intent = Intent(applicationContext, DashboardActivity::class.java)
            intent.putExtra("productID", "2")
            startActivity(intent)
        }

    }

}