package br.com.globoplay.presentation.streams.list.domain.useCase

import br.com.globoplay.presentation.streams.list.domain.repository.ListStreamsRepository

class GetGenreWithStreamsUseCaseImpl(
    private val listStreamsRepository: ListStreamsRepository
) : GetGenreWithStreamsUseCase {

    override suspend fun invoke() = listStreamsRepository.getGenreWithStreams()

}