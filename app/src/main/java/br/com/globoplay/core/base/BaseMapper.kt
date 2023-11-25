package br.com.globoplay.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class BaseMapper<DTO, DomainModel> {

    abstract fun mapToDomainModel(dto: DTO): DomainModel
    abstract fun mapToDTO(domainModel: DomainModel): DTO

    fun mapToDomainModelList(dtoList: List<DTO>?) =
        dtoList?.map { mapToDomainModel(it) }.orEmpty()

    fun mapToDomainModelList(dtoList: Flow<List<DTO>?>) =
        dtoList.map { mapToDomainModelList(it) }

    fun mapToDTOList(domainModelList: List<DomainModel>?) =
        domainModelList?.map { mapToDTO(it) }.orEmpty()

    fun mapToDTOList(domainModelList: Flow<List<DomainModel>?>) =
        domainModelList.map { mapToDTOList(it) }

}