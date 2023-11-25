package br.com.globoplay.presentation.streams.list.domain.useCase

import br.com.globoplay.presentation.streams.list.domain.model.GenreWithStreams
import kotlinx.coroutines.flow.Flow

interface GetGenreWithStreamsUseCase {

    suspend operator fun invoke(): Flow<List<GenreWithStreams>>

}