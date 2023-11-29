package com.homedecors.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.homedecors.R
import com.homedecors.main.utils.SharedPreferenceManager

class DashboardActivity : AppCompatActivity() {

    lateinit var back_icon : ImageView
    lateinit var product_img : ImageView
    lateinit var product_name : TextView
    lateinit var review_edit_lay : LinearLayout
    lateinit var review_lay : LinearLayout
    lateinit var review_txt : TextView
    lateinit var btnSend : Button
    lateinit var content : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        product_img = findViewById(R.id.product_img)
        back_icon = findViewById(R.id.back_icon)
        product_name = findViewById(R.id.product_name)
        review_edit_lay = findViewById(R.id.review_edit_lay)
        review_lay = findViewById(R.id.review_lay)
        btnSend = findViewById(R.id.btnSend)
        content = findViewById(R.id.content)
        review_txt = findViewById(R.id.review_txt)

        var productID = intent.getStringExtra("productID")
        if(productID.equals("1")){
            product_img.setImageDrawable(resources.getDrawable(R.drawable.king_size_bed_cover))
            product_name.text = resources.getString(R.string.kingsize_bed)
        }else{
            product_img.setImageDrawable(resources.getDrawable(R.drawable.garden_table))
            product_name.text = resources.getString(R.string.garden_table)
        }

        btnSend.setOnClickListener {
            var contentTxt = content.text.toString()
            if(contentTxt.equals("")){
                content.error = resources.getString(R.string.error_comment)
                return@setOnClickListener
            }else{
                review_edit_lay.visibility = View.GONE
                review_lay.visibility = View.VISIBLE
                review_txt.text = contentTxt.toString()
            }
        }
        back_icon.setOnClickListener {
            finish()
        }
    }

}