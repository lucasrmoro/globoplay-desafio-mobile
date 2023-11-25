package br.com.globoplay.presentation.streams.list.domain.mapper

import br.com.globoplay.core.base.BaseMapper
import br.com.globoplay.core.extensions.orZero
import br.com.globoplay.presentation.streams.list.data.model.dto.StreamDTO
import br.com.globoplay.presentation.streams.list.domain.model.Stream

class StreamMapper : BaseMapper<StreamDTO, Stream>() {

    override fun mapToDomainModel(dto: StreamDTO): Stream = with(dto) {
        Stream(
            id = id.orZero(),
            overview = overview.orEmpty(),
            popularity = popularity.orZero(),
            posterPath = posterPath.orEmpty(),
            releaseDate = releaseDate.orEmpty(),
            title = title.orEmpty(),
            voteAverage = voteAverage.orZero(),
            voteCount = voteCount.orZero()
        )
    }

    override fun mapToDTO(domainModel: Stream): StreamDTO = with(domainModel) {
        StreamDTO(
            id = id,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }

}