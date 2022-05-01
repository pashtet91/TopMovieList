package com.pashtet.topmovielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pashtet.topmovielist.R
import com.pashtet.topmovielist.adapter.MovieListAdapter

import com.pashtet.topmovielist.databinding.ActivityMainBinding
import com.pashtet.topmovielist.model.MovieService
import com.pashtet.topmovielist.repository.MovieRepo
import com.pashtet.topmovielist.viewmodel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class  MainActivity  : AppCompatActivity() {

    lateinit var vB:ActivityMainBinding

    private lateinit var movieListAdapter: MovieListAdapter

    private  val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vB = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vB.root)
        setMovieList()
        getPopularMovies()

    }

    private fun getPopularMovies() {

        showProgressBar()

        viewModel.getAllPopularMovies().observe(this, Observer { movies ->
            hideProgressBar()
            movies?.let{
                movieListAdapter.setMovieList(movies)
            }
//            Log.i("Movies Result", "Result = $movies")
        })
    }

    private fun setMovieList(){
        vB.recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        vB.recyclerView.layoutManager = layoutManager
        movieListAdapter = MovieListAdapter(mutableListOf(),this)
        vB.recyclerView.adapter = movieListAdapter
    }

    private fun showProgressBar(){
        vB.recyclerView.isEnabled = false
        vB.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        vB.recyclerView.isEnabled = true
        vB.progressBar.visibility = View.GONE
    }
}
