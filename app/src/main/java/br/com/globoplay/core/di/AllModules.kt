package br.com.globoplay.core.di

import br.com.globoplay.presentation.streams.list.di.ListStreamsModule
import org.koin.core.module.Module

object AllModules {

    val allModules = mutableListOf<Module>().apply {
        addAll(ListStreamsModule.module + NetworkModule.module)
    }.toList()

}