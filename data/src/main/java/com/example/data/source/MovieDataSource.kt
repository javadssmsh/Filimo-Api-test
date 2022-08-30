package com.example.data.source

import com.example.data.api.MovieApiService
import com.example.data.mapper.toDomain
import com.example.domain.base.Error
import com.example.domain.base.FilimoResult
import com.example.domain.model.MovieItem
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val movieApiService: MovieApiService
) {

    suspend fun getSearchedMovies(): FilimoResult<List<MovieItem>> {
        return try {
            val result = movieApiService.getSearchedMovies("javad")
            when {
                result.isSuccessful -> {
                    result.body()?.data?.let {
                        FilimoResult.Success(it.map { item -> item.toDomain() })
                    } ?: kotlin.run {
                        FilimoResult.Error(Error.EmptyResult)
                    }
                }
                else -> {
                    FilimoResult.Error(Error.NotFound)
                }

            }
        } catch (e: Exception) {
            FilimoResult.Error(Error.Internet)
        }
    }

}