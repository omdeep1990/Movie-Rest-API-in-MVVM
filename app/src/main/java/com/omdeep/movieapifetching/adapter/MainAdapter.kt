package com.omdeep.movieapifetching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omdeep.movieapifetching.R
import com.omdeep.movieapifetching.databinding.LayoutRvItemBinding
import com.omdeep.movieapifetching.model.Movie

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var movies = mutableListOf<Movie>()

    fun setMoviesList(movie : List<Movie>) {
        this.movies = movie.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title
        holder.binding.imdbId.text = "ID: "+ movie.imdbID
        holder.binding.year.text = "Year: "+ movie.year
        Glide.with(holder.itemView.context).load(movie.poster).placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

