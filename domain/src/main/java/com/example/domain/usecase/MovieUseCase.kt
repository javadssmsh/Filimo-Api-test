package com.example.domain.usecase

import com.example.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: IMovieRepository
) {

    suspend fun getSearchedMovies() = movieRepository.getSearchedMovies()
}