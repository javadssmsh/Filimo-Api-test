package com.example.domain.repository

interface IMovieRepository {

    suspend fun getSearchedMovies()
}