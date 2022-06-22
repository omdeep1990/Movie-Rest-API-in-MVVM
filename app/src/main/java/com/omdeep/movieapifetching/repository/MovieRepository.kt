package com.omdeep.movieapifetching.repository

import com.omdeep.movieapifetching.retrofitService.RetrofitService

class MovieRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}