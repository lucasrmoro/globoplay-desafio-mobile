package br.com.globoplay.presentation.streams.list.domain.mapper

import br.com.globoplay.core.base.BaseMapper
import br.com.globoplay.core.extensions.orZero
import br.com.globoplay.presentation.streams.list.data.model.dto.GenreDTO
import br.com.globoplay.presentation.streams.list.domain.model.Genre

class GenreMapper : BaseMapper<GenreDTO, Genre>() {

    override fun mapToDomainModel(dto: GenreDTO) = with(dto) {
        Genre(id = id.orZero(), name = name.orEmpty())
    }

    override fun mapToDTO(domainModel: Genre) = with(domainModel) {
        GenreDTO(id = id, name = name)
    }

}