package br.com.globoplay.presentation.streams.list.di

import br.com.globoplay.core.base.BaseDIModule
import br.com.globoplay.core.extensions.getApi
import br.com.globoplay.presentation.streams.list.data.ListStreamsAPI
import br.com.globoplay.presentation.streams.list.data.ListStreamsDataSource
import br.com.globoplay.presentation.streams.list.domain.repository.ListStreamsRepository
import br.com.globoplay.presentation.streams.list.domain.repository.ListStreamsRepositoryImpl
import br.com.globoplay.presentation.streams.list.domain.useCase.GetGenreWithStreamsUseCase
import br.com.globoplay.presentation.streams.list.domain.useCase.GetGenreWithStreamsUseCaseImpl
import br.com.globoplay.presentation.streams.list.domain.mapper.GenreMapper
import br.com.globoplay.presentation.streams.list.domain.mapper.StreamMapper
import br.com.globoplay.presentation.streams.list.presentation.screen.ListStreamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ListStreamsModule : BaseDIModule {

    override val module: Module = module {
        // API
        factory<ListStreamsAPI> { getApi() }

        // Data Source
        factory { ListStreamsDataSource(listStreamsAPI = get()) }

        // Mapper
        factory { GenreMapper() }
        factory { StreamMapper() }

        // Repository
        factory<ListStreamsRepository> {
            ListStreamsRepositoryImpl(
                genreMapper = get(),
                streamMapper = get(),
                listStreamsDataSource = get()
            )
        }

        // Use Case
        factory<GetGenreWithStreamsUseCase> {
            GetGenreWithStreamsUseCaseImpl(listStreamsRepository = get())
        }

        // ViewModel
        viewModel { ListStreamsViewModel(getGenreWithStreamsUseCase = get()) }
    }

}