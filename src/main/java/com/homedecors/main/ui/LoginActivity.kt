package com.homedecors.main.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.homedecors.R
import com.homedecors.main.utils.SharedPreferenceManager

class LoginActivity : AppCompatActivity() {

    lateinit var phonenumber : EditText
    lateinit var password : EditText
    lateinit var login : Button
    lateinit var register : Button
    var isLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        phonenumber = findViewById(R.id.phonenumber)
        password = findViewById(R.id.password)
        register = findViewById(R.id.register)
        login = findViewById(R.id.login)

        isLogin = SharedPreferenceManager.instance.getBooleanFromPreference(SharedPreferenceManager.IS_LOGGED_IN)

        phonenumber.afterTextChanged {
            validate()
        }

        password.apply {
            afterTextChanged {
                validate()
            }
        }

        register.setOnClickListener {

            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

            login.setOnClickListener {
            if(!phonenumber.text.equals("") && !password.text.equals("")){

                var phoneNumberTxt = phonenumber.text
                var passwordTxt = password.text

//                if(isLogin) {
                    var phone = SharedPreferenceManager.instance.getStringFromPreference(
                        SharedPreferenceManager.PHONENUMBER
                    );
                    var password = SharedPreferenceManager.instance.getStringFromPreference(
                        SharedPreferenceManager.PASSWORD
                    );
                    var username = SharedPreferenceManager.instance.getStringFromPreference(
                        SharedPreferenceManager.USERNAME
                    );

                    if (phoneNumberTxt.toString().equals(phone) && passwordTxt.toString().equals(password)) {
                        SharedPreferenceManager.instance.storeBooleanInPreference(SharedPreferenceManager.IS_LOGGED_IN, true);
                        val intent = Intent(applicationContext, ProductActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                else{
                    Toast.makeText(applicationContext, "Login user is not registered", Toast.LENGTH_SHORT).show()
                }

            }else{
                validate()
            }
        }

    }

    fun validate(){
        if(phonenumber.text.equals("")){
            phonenumber.error = resources.getString(R.string.error_phonenumber)
            return
        }
        if(password.text.equals("")){
            password.error = resources.getString(R.string.error_password)
            return
        }
        login.isEnabled = true
    }

    /**
     * Extension function to simplify setting an afterTextChanged action to EditText components.
     */
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}