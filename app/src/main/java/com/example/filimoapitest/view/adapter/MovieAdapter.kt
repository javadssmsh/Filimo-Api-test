package com.example.filimoapitest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.MovieItem
import com.example.filimoapitest.databinding.MovieItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var inflater: LayoutInflater

    private var movies: MutableList<MovieItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return MovieViewHolder(MovieItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }


    inner class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.movieItem = movieItem
            binding.executePendingBindings()
        }
    }

    fun sendMoviesToAdapter(newMovies: List<MovieItem>) {
        val moviesDiffUtil = MoviesDiffUtil(movies, newMovies)
        val diffUtilResult = DiffUtil.calculateDiff(moviesDiffUtil)
        movies = newMovies as MutableList<MovieItem>
        diffUtilResult.dispatchUpdatesTo(this)
    }


    override fun getItemCount(): Int {
        return movies.size
    }
}