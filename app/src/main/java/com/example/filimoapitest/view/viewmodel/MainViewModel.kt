package com.example.filimoapitest.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.Error
import com.example.domain.base.FilimoResult
import com.example.domain.model.MovieItem
import com.example.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    val videoList: MutableLiveData<List<MovieItem>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        loading.value = false
    }

    public fun getSearchedMovies(name :String) {
        startLoading()
        viewModelScope.launch {
            when (val result = movieUseCase.getSearchedMovies(name).also { stopLoading() }) {
                is FilimoResult.Success -> {
                    result.data.let {
                        videoList.value = it
                    }
                }
                is FilimoResult.Error -> {
                    when (result.error) {
                        is Error.EmptyResult -> {
                            videoList.value = emptyList()
                        }
                        else -> {
                            handleError()
                        }
                    }
                }
            }
        }
    }

    private fun startLoading() {
        loading.value = true
    }

    private fun stopLoading() {
        loading.value = false
    }

    private fun isLoading():Boolean{
        return loading.value!!
    }

    private fun handleError() {
        TODO("Not yet implemented")
    }
}