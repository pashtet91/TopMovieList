package com.pashtet.topmovielist.model

import androidx.lifecycle.LiveData
import dagger.Provides
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface MovieService {
    @GET("movie/popular")
    fun getAllPopularMovies(@Query("api_key") apiKey:String = API_KEY,
                                    @Query("language")lang:String)
        : Call<MoviewResponse>

    companion object{
        private const val API_KEY = "829b5f4451dd727792e0139c19fcb81d"
        val instance: MovieService by lazy{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(MovieService::class.java)
        }
    }
}