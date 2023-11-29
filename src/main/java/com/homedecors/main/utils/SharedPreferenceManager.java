/*
 * @category ContusFly
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.homedecors.main.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.homedecors.R;


/**
 * This class Stores and retrieves the preference in the local storage for the future use.
 *
 * @version 1.0
 */
public class SharedPreferenceManager {

    /**
     * Instance of the SharedPreferenceManager
     */
    public static final SharedPreferenceManager instance = new SharedPreferenceManager();

    /**
     * Store if the User has been  completed the login process.
     */
    public static final String IS_LOGGED_IN = "is_logged_in";

    /**
     * This key is used to store whether the user just opened the app first time.
     */
    public static final String IS_FIRST = "is_first";

    /**
     * Store the password for the user.
     */
    public static final String SECRET_KEY = "password";

    /**
     * Store the user name of the user
     */
    public static final String USERNAME = "username";
    public static final String PHONENUMBER = "phonenumber";
    public static final String EMAILADDRESS = "emailaddress";
    public static final String PASSWORD = "password";


    /**
     * The instance of SharedPreferences .
     */
    private SharedPreferences mPreferences;

    /**
     * The instance of the SharedPreferences editor
     */
    private SharedPreferences.Editor mEditor;

    Context context;

    public void init(Context context) {

            this.context = context;
            mPreferences = context.getSharedPreferences(context.getString(R.string.app_name),
                    Context.MODE_PRIVATE);
            mEditor = mPreferences.edit();
            mEditor.apply();

    }

    /**
     * Constructor of SharedPreferenceManager
     */
    private SharedPreferenceManager() {
    }

    /**
     * Store boolean in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public void storeBooleanInPreference(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    /**
     * Gets the boolean from preference.
     *
     * @param key the key
     * @return boolean Value from preference
     */
    public boolean getBooleanFromPreference(String key) {
        return mPreferences.getBoolean(key, false);
    }

    /**
     * Gets the int from preference.
     *
     * @param key the key
     * @return String Value from preference
     */
    public int getIntFromPreference(String key) {
        return mPreferences.getInt(key, 0);
    }

    /**
     * Gets the string from preference.
     *
     * @param key the key
     * @return String Value from preference
     */
    public String getStringFromPreference(String key) {
        return mPreferences.getString(key, "");
    }

    /**
     * Clear all preference.
     */
    public void clearAllPreference() {
        mEditor.clear();
        mEditor.commit();
    }

    /**
     * Store string in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public void storeStringInPreference(String key, String value) {
        mEditor.putString(key, value);
        mEditor.apply();
    }

    /**
     * Store int in preference.
     *
     * @param key   the key
     * @param value the value
     */
    public void storeIntInPreference(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    public boolean getBooleanFromPreferenceDefaultTrueValue(String key){
        return mPreferences.getBoolean(key, true);
    }

}
