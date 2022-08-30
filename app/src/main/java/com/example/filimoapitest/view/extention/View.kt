package com.example.filimoapitest.view.extention

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity


fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE)
                as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}