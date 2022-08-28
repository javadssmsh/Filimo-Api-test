package com.example.data.repository

import com.example.data.source.MovieDataSource
import com.example.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDataSource: MovieDataSource
) : IMovieRepository {


    override suspend fun getSearchedMovies() {
        movieDataSource.getSearchedMovies()
    }


}