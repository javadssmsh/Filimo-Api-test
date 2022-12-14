package com.example.domain.repository

import com.example.domain.base.FilimoResult
import com.example.domain.model.MovieItem

interface IMovieRepository {

    suspend fun getSearchedMovies(name :String) : FilimoResult<List<MovieItem>>
}