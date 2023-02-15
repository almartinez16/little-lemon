package com.example.littlelemon.data

import android.content.Context
import android.content.SharedPreferences

class PrefRepository(
    private val context: Context
) {
    private val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    private val editor = pref.edit()

    fun saveLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(PREF_LOGGED_IN,isLoggedIn).apply()
    }

    fun getLoggedIn(): Boolean {
        return pref.getBoolean(PREF_LOGGED_IN, false)
    }

    fun saveUserFirstName(firstName: String) {
        editor.putString(PREF_USER_FIRST_NAME, firstName).apply()
    }

    fun getUserFirstName(): String {
        return pref.getString(PREF_USER_FIRST_NAME, "")!!
    }

    fun saveUserLastName(lastName: String) {
        editor.putString(PREF_USER_LAST_NAME, lastName).apply()
    }

    fun getUserLastName(): String {
        return pref.getString(PREF_USER_LAST_NAME, "")!!
    }

    fun saveUserEmail(email: String) {
        editor.putString(PREF_USER_EMAIL, email).apply()
    }

    fun getUserEmail(): String {
        return pref.getString(PREF_USER_EMAIL, "")!!
    }

    fun clearSavedData() {
        editor.clear().apply()
    }
}