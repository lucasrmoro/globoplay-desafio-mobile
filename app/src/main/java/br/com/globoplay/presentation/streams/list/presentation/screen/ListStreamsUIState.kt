package br.com.globoplay.presentation.streams.list.presentation.screen

import br.com.globoplay.core.base.BaseUIState
import br.com.globoplay.presentation.streams.list.domain.model.GenreWithStreams

data class ListStreamsUIState(
    val genreWithStreams: List<GenreWithStreams> = emptyList(),
    override val errorMessage: String? = null,
    override val isLoading: Boolean = false
) : BaseUIState()