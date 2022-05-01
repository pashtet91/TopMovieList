package com.pashtet.topmovielist.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pashtet.topmovielist.databinding.ItemMovieBinding
import com.pashtet.topmovielist.model.Movie
import com.pashtet.topmovielist.model.MovieService


class MovieListAdapter (private val movies: MutableList<Movie>,
                                            private val parentActivity: Activity
                    ): RecyclerView.Adapter<MovieListAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movieList = movies[position]

        Glide.with(parentActivity)
            .load(MovieService.IMAGE_URL + movieList.poster_path)
            .into(holder.movieImage)

        holder.movieTitle.text = movieList.title
        holder.movieReleaseDate.text = movieList.release_date
    }

    override fun getItemCount(): Int {
        return movies.size ?: 0
    }

    fun setMovieList(movieList: List<Movie>){
        this.movies.clear()
        this.movies.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(vB: ItemMovieBinding):RecyclerView.ViewHolder(vB.root){
        var movieImage: ImageView = vB.imageView
        var movieTitle: TextView = vB.titleTV
        var movieReleaseDate: TextView = vB.releaseDateTV

    }
}