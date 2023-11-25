package br.com.globoplay.core.base

import kotlinx.coroutines.flow.flow

abstract class BaseDataSource {

    protected fun <T> call(block: suspend () -> T) = flow { emit(block()) }

}