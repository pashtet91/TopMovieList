package com.pashtet.topmovielist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pashtet.topmovielist.daggerComponent.DaggerRepoComponent
import com.pashtet.topmovielist.model.Movie

class MainViewModel(application: Application)
    : AndroidViewModel(application) {

    //val movieService = MovieService.instance
    private val movieRepo = DaggerRepoComponent.create().getRepository()

    fun getAllPopularMovies():LiveData<List<Movie>?> {
        return movieRepo.getAllPopularMovies()//.value?.results as LiveData<List<Movie>?>
    }
}