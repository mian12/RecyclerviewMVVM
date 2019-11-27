package com.shahbaz.recyclerviewmvvm.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shahbaz.recyclerviewmvvm.R
import com.shahbaz.recyclerviewmvvm.data.models.Movies
import com.shahbaz.recyclerviewmvvm.databinding.RecyclerviewMovieBinding

class MoviesAdapter(
    private val moviesList: List<Movies>

) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )

        )

    override fun getItemCount() = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        holder.recyclerviewMovieBinding.movie = moviesList[position]
    }


    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)
}