package com.example.data.api

import com.example.data.model.SearchMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {


    @GET("api/en/v1/movie/movie/list/tagid/1000300/text/{Query}/sug/on")
    suspend fun getSearchedMovies(
        @Path("Query")
        name: String
    ): Response<SearchMovieResponse>


}