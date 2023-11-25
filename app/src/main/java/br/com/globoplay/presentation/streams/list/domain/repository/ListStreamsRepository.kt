package br.com.globoplay.presentation.streams.list.domain.repository

import br.com.globoplay.presentation.streams.list.domain.model.GenreWithStreams
import kotlinx.coroutines.flow.Flow

interface ListStreamsRepository {

    suspend fun getGenreWithStreams(): Flow<List<GenreWithStreams>>

}