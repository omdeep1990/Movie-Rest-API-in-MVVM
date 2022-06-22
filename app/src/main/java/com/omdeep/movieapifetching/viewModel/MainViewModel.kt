package com.omdeep.movieapifetching.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.movieapifetching.model.Movie
import com.omdeep.movieapifetching.model.MovieList
import com.omdeep.movieapifetching.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MovieRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage =MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                movieList.postValue(response.body()?.mList)
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}