package com.omdeep.movieapifetching.retrofitService

import retrofit2.Call
import com.omdeep.movieapifetching.model.MovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("api?s=batman")
    fun getAllMovies(): Call<MovieList>

    //TODO: Companion object for fetching Retrofit function members
    companion object {
        var retrofitService : RetrofitService? = null

        //TODO: Creating retrofit service instance using the retrofit
        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://fake-movie-database-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}