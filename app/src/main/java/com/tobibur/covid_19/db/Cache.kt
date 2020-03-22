package com.tobibur.covid_19.db

import android.content.Context
import android.content.SharedPreferences
import java.io.Serializable


class Cache(context: Context){
    // Shared Preferences
    private var pref: SharedPreferences

    // Editor for Shared preferences
    private var editor: SharedPreferences.Editor

    // Shared pref mode
    private var PRIVATE_MODE = 0

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    /**
     * Get stored session data
     */



    fun saveData(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanData(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun getData(key: String): String? {
        return pref.getString(key, null)
    }

    fun getIntData(key: String): Int {
        return pref.getInt(key, 0)
    }

    // Get Login State
    val isTokenSaved: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)

    // Save Token
    fun saveData(key: String, value: String) {

        editor.putBoolean(IS_LOGIN, true)

        editor.putString(key, value)
        editor.apply()
    }

    fun saveData(key: String, value: Int) {

        editor.putBoolean(IS_LOGIN, true)

        editor.putInt(key, value)
        editor.apply()
    }



    // clear token
    fun clear() {

        // Clearing all data from Shared Preferences
        editor.clear()
        editor.commit()
    }

    companion object {

        // Sharedpref file name
        private const val PREF_NAME = "global_pref"
        // All Shared Preferences Keys
        private const val IS_LOGIN = "IsLoggedIn"

        const val COUNTRY_NAME = "country_name"
    }
}
