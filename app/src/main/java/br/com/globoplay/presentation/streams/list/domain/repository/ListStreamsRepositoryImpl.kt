package br.com.globoplay.presentation.streams.list.domain.repository

import br.com.globoplay.core.extensions.collectResult
import br.com.globoplay.core.extensions.concurrentMap
import br.com.globoplay.presentation.streams.list.data.ListStreamsDataSource
import br.com.globoplay.presentation.streams.list.domain.mapper.GenreMapper
import br.com.globoplay.presentation.streams.list.domain.mapper.StreamMapper
import br.com.globoplay.presentation.streams.list.domain.model.GenreWithStreams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ListStreamsRepositoryImpl(
    private val genreMapper: GenreMapper,
    private val streamMapper: StreamMapper,
    private val listStreamsDataSource: ListStreamsDataSource
) : ListStreamsRepository {

    override suspend fun getGenreWithStreams(): Flow<List<GenreWithStreams>> =
        listStreamsDataSource.getGenres().map { genres ->
            genres?.concurrentMap { genreDTO ->
                val streams = listStreamsDataSource.getStreams(genreDTO.id).collectResult()
                GenreWithStreams(
                    genre = genreMapper.mapToDomainModel(genreDTO),
                    streams = streamMapper.mapToDomainModelList(streams.orEmpty())
                )
            }?.sortedByDescending { it.genre.name }.orEmpty()
        }


}