package br.com.globoplay.presentation.streams.list.data

import br.com.globoplay.presentation.streams.list.data.model.response.GenresResponse
import br.com.globoplay.presentation.streams.list.data.model.response.StreamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ListStreamsAPI {

    @GET(GET_GENRES)
    suspend fun getGenres(): GenresResponse

    @GET(GET_STREAMS)
    suspend fun getStreams(@Query("with_genres") genreId: String?): StreamsResponse

    companion object {
        private const val GET_GENRES = "genre/movie/list"
        private const val GET_STREAMS = "discover/movie"
    }
}