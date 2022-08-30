package com.example.filimoapitest.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filimoapitest.R
import com.example.filimoapitest.databinding.ActivityMainBinding
import com.example.filimoapitest.view.adapter.MovieAdapter
import com.example.filimoapitest.view.extention.hideKeyboard
import com.example.filimoapitest.view.extention.inVisible
import com.example.filimoapitest.view.extention.visible
import com.example.filimoapitest.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView()
        initObserver()

    }

    private fun initView() {

        movieAdapter = MovieAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = movieAdapter
            itemAnimator = DefaultItemAnimator()
        }

        binding.searchBtn.setOnClickListener {
            val inputText :String = binding.searchTextBox.text.toString()
            if (!inputText.isNullOrBlank()) {
                viewModel.getSearchedMovies(inputText)
                binding.searchBtn.hideKeyboard()
            } else {
                Toast.makeText(this, getString(R.string.enter_movie_name_correctly), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initObserver() {
        viewModel.videoList.observe(this) {
            movieAdapter.sendMoviesToAdapter(it)
        }

        viewModel.loading.observe(this) {
            if (it)
                binding.progressBar.visible()
            else
                binding.progressBar.inVisible()
        }
    }
}