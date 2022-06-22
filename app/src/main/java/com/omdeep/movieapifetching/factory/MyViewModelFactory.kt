package com.omdeep.movieapifetching.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omdeep.movieapifetching.repository.MovieRepository
import com.omdeep.movieapifetching.viewModel.MainViewModel
import java.lang.IllegalArgumentException

class MyViewModelFactory constructor(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found!!")
    }
}