package com.example.filimoapitest.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.filimoapitest.R
import com.example.filimoapitest.view.viewmodel.MainViewModel
import dagger.hilt.android.scopes.ActivityScoped


@ActivityScoped
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}