package com.pashtet.topmovielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pashtet.topmovielist.R
import com.pashtet.topmovielist.model.MovieService
import com.pashtet.topmovielist.repository.MovieRepo
import com.pashtet.topmovielist.viewmodel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private  val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val movieService = MovieService.instance
//        val movieRepo = MovieRepo(movieService)
//

//            val results = viewModel.getAllPopularMovies()

//            Log.i("Movies Result", "Result = ${results.body()}")
            getPopularMovies()



    }

    private fun getPopularMovies() {

        viewModel.getAllPopularMovies().observe(this, Observer { movies ->

            Log.i("Movies Result", "Result = $movies")
        })
    }
}
