package com.pashtet.topmovielist.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pashtet.topmovielist.model.Movie
import com.pashtet.topmovielist.model.MovieService
import com.pashtet.topmovielist.model.MoviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepo @Inject constructor (private val movieService: MovieService){

    fun getAllPopularMovies(language:String = ""): LiveData<List<Movie>?>
    //= movieService.getAllPopularMovies(lang= language)
    {
        val data = MutableLiveData<List<Movie>>()

        movieService.getAllPopularMovies(lang= language).enqueue(object : Callback<MoviewResponse>{
            override fun onResponse(
                call: Call<MoviewResponse>,
                response: Response<MoviewResponse>
            ) {
                data.value = response.body()?.results
            }

            override fun onFailure(call: Call<MoviewResponse>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

}