package com.homedecors.main.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.homedecors.R
import com.homedecors.main.utils.SharedPreferenceManager

class RegisterActivity : AppCompatActivity() {

    lateinit var phonenumber : EditText
    lateinit var emailaddress : EditText
    lateinit var password : EditText
    lateinit var register : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_layout)

        phonenumber = findViewById(R.id.phonenumber)
        emailaddress = findViewById(R.id.emailaddress)
        password = findViewById(R.id.password)
        register = findViewById(R.id.register)

        password.afterTextChanged {
            validate()
        }

        register.setOnClickListener {
            if(!phonenumber.text.equals("") &&
                !emailaddress.text.equals("") && !password.text.equals("")){

                var phoneNumberTxt = phonenumber.text
                var emailAddressTxt = emailaddress.text
                var passwordTxt = password.text

                SharedPreferenceManager.instance.storeStringInPreference(
                    SharedPreferenceManager.USERNAME, phoneNumberTxt.toString());
                SharedPreferenceManager.instance.storeStringInPreference(
                    SharedPreferenceManager.PHONENUMBER, phoneNumberTxt.toString());
                SharedPreferenceManager.instance.storeStringInPreference(
                    SharedPreferenceManager.EMAILADDRESS, emailAddressTxt.toString());
                SharedPreferenceManager.instance.storeStringInPreference(
                    SharedPreferenceManager.PASSWORD, passwordTxt.toString());
                SharedPreferenceManager.instance.storeBooleanInPreference(
                    SharedPreferenceManager.IS_LOGGED_IN, true);

                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
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
        if(emailaddress.text.equals("")){
            emailaddress.error = resources.getString(R.string.error_email)
            return
        }
        if(password.text.equals("")){
            password.error = resources.getString(R.string.error_password)
            return
        }
        register.isEnabled = true
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