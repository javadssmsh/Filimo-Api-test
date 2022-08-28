package com.example.filimoapitest.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    init {
        getSearchedMovies()
    }

    private fun getSearchedMovies() {
        viewModelScope.launch {
            movieUseCase.getSearchedMovies()
        }
    }
}