package br.com.globoplay.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : BaseUIState> : ViewModel() {


    protected abstract val _uiState: MutableStateFlow<T>
    val uiState: StateFlow<T>
        get() = _uiState

    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(block = block)

}