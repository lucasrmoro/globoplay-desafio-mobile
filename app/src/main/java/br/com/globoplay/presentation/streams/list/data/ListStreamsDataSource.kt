package br.com.globoplay.presentation.streams.list.data

import br.com.globoplay.core.base.BaseDataSource

class ListStreamsDataSource(
    private val listStreamsAPI: ListStreamsAPI
) : BaseDataSource() {

    suspend fun getStreams(genreId: Long?) =
        call { listStreamsAPI.getStreams(genreId?.toString()).streams }

    suspend fun getGenres() = call { listStreamsAPI.getGenres().genres }

}