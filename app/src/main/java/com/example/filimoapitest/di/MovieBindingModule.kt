package com.example.filimoapitest.di

import com.example.data.api.MovieApiService
import com.example.data.repository.MovieRepository
import com.example.data.source.MovieDataSource
import com.example.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieBindingModule {

    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepository): IMovieRepository

}

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {

    @Provides
    fun provideMovieRepositoryUseCase(movieDataSource: MovieDataSource) =
        MovieRepository(movieDataSource)


    @Provides
    fun provideSerialDataSource(
        movieApiService: MovieApiService,
    ) = MovieDataSource(movieApiService)
}