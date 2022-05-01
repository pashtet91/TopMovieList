package com.pashtet.topmovielist.daggerComponent

import com.pashtet.topmovielist.model.MovieService
import dagger.Module
import dagger.Provides

@Module
class RepoModule {
    @Provides
    fun provideMovieService():MovieService{
        return MovieService.instance
    }
}