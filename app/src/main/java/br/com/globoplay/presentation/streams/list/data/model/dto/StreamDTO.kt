package br.com.globoplay.presentation.streams.list.data.model.dto

import com.google.gson.annotations.SerializedName

data class StreamDTO(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("adult") val isAdult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val isVideo: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
)