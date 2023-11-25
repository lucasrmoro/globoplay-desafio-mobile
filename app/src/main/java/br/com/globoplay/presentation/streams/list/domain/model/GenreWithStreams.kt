package br.com.globoplay.presentation.streams.list.domain.model

data class GenreWithStreams(
    val genre: Genre,
    val streams: List<Stream>
)