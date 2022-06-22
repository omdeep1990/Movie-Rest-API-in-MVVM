package com.omdeep.movieapifetching.model


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String
)