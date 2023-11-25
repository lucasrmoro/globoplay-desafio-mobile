package br.com.globoplay.presentation.streams.list.domain.model

data class Stream(
    val id: Int,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
) {

    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w300/$posterPath"

}