package com.enjaz.hr.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.enjaz.hr.HRMApp
import com.google.gson.Gson


class PrefsManager {
    private var context = HRMApp
    private var mGson: Gson = Gson()
    private var sharedPref: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext())
    private lateinit var sharedPrefsEditor: SharedPreferences.Editor

    private fun getString(id: Int): String {
        return context.instance!!.getString(id)
    }


    fun getString(string:String): String? {
        val string = sharedPref.getString(string, null)
        return string
    }
    fun getRefreshToken(): String? {
        val refreshToken = sharedPref.getString("refreshToken", null)
        return refreshToken
    }

    fun getAccessToken(): String? {
        val accessToken = sharedPref.getString("accessToken", null)
        return accessToken
    }


    fun saveAccessToken(token: String?) {

        sharedPrefsEditor = sharedPref.edit()
        sharedPrefsEditor.putString("accessToken", token)
        sharedPrefsEditor.apply()
    }

    fun saveRefreshToken(token: String?) {

        sharedPrefsEditor = sharedPref.edit()
        sharedPrefsEditor.putString("refreshToken", token)
        sharedPrefsEditor.apply()
    }


    fun setString(key: String, value: String) {

        sharedPrefsEditor = sharedPref.edit()
        sharedPrefsEditor.putString(key, value)
        sharedPrefsEditor.apply()


    }

    companion object {

        var instance: PrefsManager? = null
            private set

        fun init(context: Context) {
            if (instance == null) {
                instance = PrefsManager()
            }
        }
    }
}
