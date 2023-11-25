package br.com.globoplay.presentation.streams.list.presentation.screen

import br.com.globoplay.core.base.BaseViewModel
import br.com.globoplay.core.extensions.onError
import br.com.globoplay.core.extensions.onSuccess
import br.com.globoplay.presentation.streams.list.domain.useCase.GetGenreWithStreamsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class ListStreamsViewModel(private val getGenreWithStreamsUseCase: GetGenreWithStreamsUseCase) :
    BaseViewModel<ListStreamsUIState>() {

    override val _uiState = MutableStateFlow(ListStreamsUIState())

    fun getGenreWithStreams() {
        launch {
            getGenreWithStreamsUseCase().onStart {
                _uiState.update { it.copy(isLoading = true) }
                println("START FLOW")
            }.onError {
                _uiState.update {
                    it.copy(errorMessage = message)
                }
            }.onCompletion {
                _uiState.update {
                    it.copy(isLoading = false)
                }
            }.onSuccess {
                _uiState.update {
                    it.copy(genreWithStreams = this)
                }
            }
        }
    }
}