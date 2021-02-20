package com.spain_cargo.cargo.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) =
    this?.let { Toast.makeText(it, textId, duration).show() }

fun View.snackbar(snackbarText: String) {
    Snackbar.make(this, snackbarText, Snackbar.LENGTH_LONG).show()
}

fun Any?.print(tag: String = "abdalla1997") {
    this?.also {
        Log.d(tag, it.toString())
    }
}

fun Int?.toFormat(): String {
    return DecimalFormat("#,###", DecimalFormatSymbols.getInstance(Locale.US)).format(this) + " د.ع"
}