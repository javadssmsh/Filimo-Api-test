package com.example.data.repository

import com.example.data.source.MovieDataSource
import com.example.domain.base.FilimoResult
import com.example.domain.model.MovieItem
import com.example.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDataSource: MovieDataSource
) : IMovieRepository {


    override suspend fun getSearchedMovies(name :String) : FilimoResult<List<MovieItem>> {
        return movieDataSource.getSearchedMovies(name)
    }


}