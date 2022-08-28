package com.example.data.source

import android.util.Log
import com.example.data.api.MovieApiService
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val movieApiService: MovieApiService
) {

    suspend fun getSearchedMovies() {

        val result = movieApiService.getSearchedMovies("javad")

        when {
            result.isSuccessful -> {
                result.body()?.let {
                    for (item in it)
                        Log.d("getSearchedMovies", "item is  :  ${item.type}")
                }
            }
            else -> {
                Log.d("getSearchedMovies", "failed !!")
            }

        }
    }

}